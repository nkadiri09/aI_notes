
``` text
# Prompt: Generate JUnit Test Cases for a Java Class

Act as a **senior Java developer specializing in unit testing and clean code practices**.

Your task is to generate **JUnit test cases** for the provided Java class.

## Requirements

### 1. Testing Framework
- Use **JUnit 5**
- Use **Mockito** for mocking dependencies
- Use **AssertJ** or standard JUnit assertions where appropriate

### 2. Compilation Safety
Ensure that:
- The test code **compiles without errors**
- All dependencies are **properly mocked**
- All required imports are included
- No undefined variables or missing classes exist

### 3. Test Coverage
Generate test cases that cover:

- All **public methods** in the class
- **Happy path scenarios**
- **Edge cases**
- **Exception scenarios**
- **Null input handling** (if applicable)

Each method in the class must have **at least one corresponding test method**.

Example:

If the class is:


```

## Mock dependencies

```text


### 4. Mocking Dependencies
If the class contains dependencies such as:

- Repository
- DAO
- External service
- REST client

Use **Mockito annotations**:


```


```text
@Mock
@InjectMocks
Initialize them properly using:


### 5. Test Naming Convention

Use descriptive method names:
methodName_shouldExpectedBehavior_whenCondition
getEmployee_shouldReturnEmployee_whenEmployeeExists


### 6. Assertions
Use meaningful assertions to validate:

- returned values
- object fields
- exceptions
- interaction with mocks

Example:

```

## Complete junit test code

```text

The code must include:

- package declaration (if applicable)
- imports
- class definition
- test methods
- mock setup
- assertions

### 8. Important Constraints

- Do **not modify the original class**
- Tests must **pass based on the current implementation**
- Avoid unnecessary mocking
- Ensure **clean, readable, production-quality test code**

---

## Input Class

Provide the following Java class:

```java
// Paste your Java class here
```
