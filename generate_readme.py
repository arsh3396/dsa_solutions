import os
import re

def generate_dashboard():
    base_dir = "src"
    readme_path = "README.md"

    if not os.path.exists(base_dir) or not os.path.exists(readme_path):
        print("Missing src/ folder or README.md file!")
        return

    # 1. Scan the src directory for topic folders and java files
    topics = sorted([d for d in os.listdir(base_dir) if os.path.isdir(os.path.join(base_dir, d))])

    total_solved = 0
    metrics_table = "| Topic Collection | Questions Solved |\n| :--- | :---: |\n"
    index_content = ""

    for topic in topics:
        topic_path = os.path.join(base_dir, topic)
        # Find all valid Java files inside the topic directory
        java_files = sorted([f for f in os.listdir(topic_path) if f.endswith(".java")])
        count = len(java_files)

        if count == 0:
            continue

        total_solved += count
        metrics_table += f"| 📂 {topic} | **{count}** |\n"

        # Format the links nicely for GitHub markdown
        index_content += f"\n### {topic}\n"
        for file in java_files:
            problem_name = file.replace(".java", "")
            # Adds spaces between CamelCase names (e.g., "TwoSum" -> "Two Sum")
            formatted_name = re.sub(r'(?<!^)(?=[A-Z])', ' ', problem_name)
            relative_url = f"./src/{topic}/{file}"
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
