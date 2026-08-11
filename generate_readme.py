import os
import re

def generate_dashboard():
    base_dir = "src"
    readme_path = "README.md"

    if not os.path.exists(base_dir) or not os.path.exists(readme_path):
        print("Missing src/ folder or README.md file!")
        return

    # Dictionary to hold structures: {"Topic" or "Topic / SubTopic": [list_of_java_files]}
    structured_index = {}
    total_solved = 0

    # 1. Recursively walk through src directory
    for root, dirs, files in os.walk(base_dir):
        # Filter and sort Java files in the current folder
        java_files = sorted([f for f in files if f.endswith(".java")])
        if not java_files:
            continue

        # Get path relative to 'src' folder (e.g., "BinarySearch" or "BinarySearch/OnAnswer")
        relative_folder = os.path.relpath(root, base_dir)

        # Format the topic heading name for the markdown (e.g., "BinarySearch / OnAnswer")
        topic_heading = relative_folder.replace(os.sep, " / ")

        structured_index[topic_heading] = {
            "files": java_files,
            "root_path": root
        }
        total_solved += len(java_files)

    # Sort topics alphabetically
    sorted_topics = sorted(structured_index.keys())

    # Build Metrics Table and Index Content
    metrics_table = "| Topic Collection | Questions Solved |\n| :--- | :---: |\n"
    index_content = ""

    for topic in sorted_topics:
        files_data = structured_index[topic]
        java_files = files_data["files"]
        root_path = files_data["root_path"]
        count = len(java_files)

        # Use 📂 icon for top-level folders, and 📁 icon for nested subfolders
        icon = "📂" if " / " not in topic else "📁"
        metrics_table += f"| {icon} {topic} | **{count}** |\n"

        # Match heading depth based on subfolder depth (### for main, #### for subfolders)
        heading_prefix = "####" if " / " in topic else "###"
        index_content += f"\n{heading_prefix} {topic}\n"

        for file in java_files:
            problem_name = file.replace(".java", "")
            # Adds spaces between CamelCase names
            formatted_name = re.sub(r'(?<!^)(?=[A-Z])', ' ', problem_name)

            # Dynamically resolve accurate relative URL
            relative_url = "./" + os.path.normpath(os.path.join(root_path, file)).replace(os.sep, "/")
            index_content += f"- [{formatted_name}]({relative_url})\n"

    metrics_table += f"| **Total Progress** | **{total_solved} / 175+** |\n"

    # 2. Read the existing README.md template
    with open(readme_path, "r", encoding="utf-8") as f:
        content = f.read()

    # 3. Replace text inside hidden markers using Regex matching
    content = re.sub(
        r"<!-- START_METRICS -->.*?<!-- END_METRICS -->",
        f"<!-- START_METRICS -->\n\n{metrics_table}\n<!-- END_METRICS -->",
        content, flags=re.DOTALL
    )
    content = re.sub(
        r"<!-- START_INDEX -->.*?<!-- END_INDEX -->",
        f"<!-- START_INDEX -->\n{index_content}\n<!-- END_INDEX -->",
        content, flags=re.DOTALL
    )

    # 4. Write back the updated file layout
    with open(readme_path, "w", encoding="utf-8") as f:
        f.write(content)

    print(f"Success! Indexed {total_solved} problems.")

if __name__ == "__main__":
    generate_dashboard()
