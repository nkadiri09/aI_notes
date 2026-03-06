# Improving Prompts for Code Refactoring

To improve a prompt for tasks like **Java code refactoring**, the goal is to make the prompt:

- **Structured**
- **Clear**
- **Constraint-driven**
- **Outcome-oriented**

A strong prompt typically contains the following elements:

| Element | Description |
|-------|-------------|
| **Role** | Defines how the model should behave (e.g., Senior Java Engineer) |
| **Context** | Explains the problem or code scenario |
| **Task** | Specifies what the model must do |
| **Rules / Constraints** | Coding standards, architecture rules |
| **Output Format** | Defines how the result should be structured |

---

# Improved Version of the Prompt

```text
Act as a senior Java software engineer performing an enterprise-grade code review.

Refactor the following Java code to align with enterprise coding standards and best practices.

Requirements:

1. Naming Conventions
   - Use camelCase for variables and methods
   - Use PascalCase for classes
   - Use descriptive, meaningful names

2. Code Quality Improvements
   - Remove code smells such as:
     - deep nesting
     - redundant logic
     - duplicated code
   - Replace magic numbers with named constants
   - Improve readability and maintainability

3. Documentation
   - Add proper Javadoc for all public classes and methods
   - Add inline comments for complex or non-obvious logic

4. Robustness
   - Use Optional where null values may occur
   - Add appropriate null checks and validations
   - Improve error handling where needed

5. Best Practices
   - Follow clean code principles
   - Prefer immutability where possible
   - Ensure the refactored code is production-ready

Output Format:
1. Provide the refactored Java code
2. Provide a brief explanation of the improvements made
3. Highlight major refactoring decisions
```

# Advanced Prompt Pattern (Recommended)

## For more reliable results, use the Analyze → Refactor → Explain pattern.

``` text
Act as a senior Java architect.

Given the following Java code:

1. First analyze the code and identify:
   - code smells
   - naming violations
   - maintainability issues

2. Then refactor the code following:
     - enterprise Java standards
   - clean code principles
   - proper documentation

3. Finally explain the improvements made.

Return the result in the following structure:

Analysis:
...

Refactored Code:
...

Explanation:
...

```
