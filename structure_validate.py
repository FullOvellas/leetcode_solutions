import os
import re

dir_iterator = os.walk(".")
dirpath, dirnames, filenames = dir_iterator.__next__()
dirnames.remove(".git")
dirnames.remove(".github")
dirpath, dirnames, filenames = dir_iterator.__next__()

incorrect_problem_dirnames: list[str] = []
incorrect_solution_dirnames: list[str] = []
solutions_with_missing_files: list[str] = []
problems_missing_descriptions: list[str] = []
has_errors = False
skip_description_check = False

for dir in dirnames:
    if re.fullmatch(r"\d+_[\w_]+", dir) is None:
        incorrect_problem_dirnames.append(dir)
        skip_description_check = True
        has_errors = True

for dir in dirnames:
    problem_dir, user_dirs, problem_files = dir_iterator.__next__()
    problem_num = re.fullmatch(r"(\d+)_[\w_]+", dir).groups()[0]
    if not skip_description_check and (len(problem_files) != 1 or problem_files[0] != f"{problem_num}_Description.md"):
        has_errors = True
        problems_missing_descriptions.append(problem_dir)

    for j in range(len(user_dirs)):
        user_path, lang_dirs, _ = dir_iterator.__next__()

        for _ in lang_dirs:
            lang_path, solution_dirs, _ = dir_iterator.__next__()
            solution_dirs.sort()
            print(lang_path)
            for idx, dir in enumerate(solution_dirs):
                print("\t", idx, dir)
                try:
                    dir_to_int = int(dir)
                    if dir_to_int != idx + 1:
                        has_errors = True
                        incorrect_solution_dirnames.append(os.path.join(lang_path, dir))
                except Exception:
                    has_errors = True
                    incorrect_solution_dirnames.append(dir)

            for l in range(len(solution_dirs)):
                solution_path, dn, solution_files = dir_iterator.__next__()
                if len(solution_files) < 1:
                    has_errors = True
                    solutions_with_missing_files.append(solution_path)

if len(incorrect_problem_dirnames) > 0:
    print("Incorrect problem directory names:")
    for dir in incorrect_problem_dirnames:
        print(f"\t{dir}")

if len(incorrect_solution_dirnames) > 0:
    print("Incorrect solution directory names:")
    for path in incorrect_solution_dirnames:
        print(f"\t{path}")

if len(solutions_with_missing_files) > 0:
    print("The following solution directories were empty:")
    for path in solutions_with_missing_files:
        print(f"\t{path}")

if len(problems_missing_descriptions) > 0:
    print("The following problems don't have a matching description file:")
    for problem in problems_missing_descriptions:
        print(f"\t{problem}")

if has_errors:
    exit(1)
