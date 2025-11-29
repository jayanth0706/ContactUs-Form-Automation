# 🚀 Selenium Automation Framework | Java + TestNG + Allure
This project is an end-to-end **Selenium Automation Framework** built using **Java, TestNG, Page Object Model (POM), Apache POI, and Allure Reporting**.  
It automates the *Contact Form* of **NS Constructions**, validates fields, handles alerts, performs data-driven testing, and generates detailed reports.
Check out the full project walkthrough on LinkedIn:
👉 🔗 Demo: [LinkedIn Post ↗] (https://www.linkedin.com/posts/jayanth0706_happy-to-share-my-new-selenium-automation-activity-7400437277526679552-Th7o?utm_source=share&utm_medium=member_desktop&rcm=ACoAAD5CO-oBKqXjdv5w4LD6ytcFmG6wpfwhdOg)

## ✔️ Key Features
- 🧩 **Page Object Model (POM)** for scalable and maintainable architecture  
- 🧪 **TestNG** for test execution, assertions & DataProviders  
- 📊 **Excel-based data-driven testing** using Apache POI  
- 🔍 **Strong field validations**, including:
  - Full Name → letters and spaces only  
  - Phone Number → digits only, exactly 10 digits  
  - Email → strict regex format  
  - Message → alphabets, numbers, spaces, and @ only  
- ⚠️ **Alert popup handling** after form submission  
- 📸 **Allure Reports** with automatic screenshot on failure  
- 🛠 **Reusable utilities** for scrolling, waiting, and reading Excel files  
- 🌐 Framework ready for cross-browser support

## 📁 Project Structure
```text
selenium-contact-automation/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/
│   │   │   ├── pages/
│   │   │   ├── utils/
│   │   │   └── listeners/
│   │   └── resources/
│   │       └── TestData.xlsx
│   │
│   ├── test/
│   │   ├── java/
│   │   │   └── tests/
│   │   └── resources/
│
├── pom.xml
├── testng.xml
├── README.md
└── .gitignore
```

## ▶️ How to Run the Tests
### 1️⃣ Clone the repository
```sh
git clone https://github.com/jayanth0706/ContactUs-Form-Automation
cd ContactUs-Form-Automation
```
### 2️⃣ Install dependencies
```sh
mvn clean install
```
### 3️⃣ Execute tests
```sh
mvn test
```

## 📊 Generate Allure Reports
### Live serve report:
```sh
allure serve allure-results
```

## 🛠 Tech Stack
- Selenium WebDriver
- Java
- TestNG
- Apache POI (Excel Reader)
- Allure Reports
- Maven
- Page Object Model (POM)

## 📧 Contact
Feel free to connect for collaboration or queries:

**Pavanagundla Jayanth**  
**Software Test Engineer**  

🔗 **LinkedIn:** [Jayanth0706](https://linkedin.com/in/jayanth0706)

