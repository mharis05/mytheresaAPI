# mytheresaAPI
Simple API Tests for Github search/repositories endpoint using Java, RestAssured, Jackson, TestNG and ExtentReports

## Tech Stack
- Java SDK
- RestAssured 
- TestNG (Test Management, DataProvider and Listeners)
- ExtentReports
- Jackson (For deserialization - Demo purposes)

## How to run
### From Command Line
1. Clone this repository
2. Open a terminal window and cd to project root 
3. Run `mvn clean test`

### From an IDE
1. Open the project and wait for dependencies for resolve
2. Locate file `testng.xml` on project root, right click and select Run

### Tests
#### - Validate that status code to search/repositories endpoint is 200
**Purpose:** Check that success status code is returned by ../search/repositories endpoint

#### - Validate that keys 'total_count', 'incomplete_results' and 'items' are present in response.
**Purpose:** Check expected keys are present in the response

#### - Validate that correct values for Repository information are returned
**Purpose:** Check values returned for a specific search query, correct values are returned.
This test demonstrates the use of JSON (De) Serialization to validate the response schema and values.

### Report
Once test execution completed, an HTML report can be found at `TestReport/Test-Automaton-Report.html`

### NOTES: 
- Due to restriction on Github API of one session per token, tests cannot be run in parallel.
- API response is paginated to 30 results by default.
