# Medi Search

## Smart Patient Record Search and Similar Case Identification

Medi Search is a Data Structures and Algorithms (DSA) project designed to
efficiently search and retrieve information from hospital patient records
stored as text files.

The project applies different algorithmic techniques for different search
requirements, including exact pattern matching, multiple-pattern searching,
fuzzy matching, and similar-case identification.

## Project Structure

MediSearch/
│
├── patient_records/
│   ├── P001.txt
│   ├── P002.txt
│   ├── P003.txt
│   └── ...
│
└── src/
    ├── PatientRecord.java
    ├── FileReaderUtil.java
    ├── KMP.java
    ├── AhoCorasick.java
    ├── Levenshtein.java
    ├── TFIDF.java
    ├── CosineSimilarity.java
    └── MediSearch.java

## Algorithms Used

### 1. KMP (Knuth-Morris-Pratt)

Purpose:
KMP is used for exact pattern searching inside patient text records.

Example:

Search:
diabetes

The algorithm searches for the word "diabetes" inside each patient record.

Time Complexity:
O(n + m)

where:
n = length of the text
m = length of the search pattern

### 2. Aho-Corasick

Purpose:
Aho-Corasick is used when multiple medical keywords need to be searched
simultaneously.

Example:

Keywords:
diabetes
fever
cough
hypertension

The algorithm can search for all these patterns while scanning a patient
record.

Main data structure:
Trie with failure links.

### 3. Levenshtein Distance

Purpose:
Levenshtein Distance is used for fuzzy searching and handling spelling
mistakes.

Example:

User enters:
diabtes

Correct term:
diabetes

The algorithm calculates the minimum number of edits required to transform
one string into another.

Technique:
Dynamic Programming.

### 4. TF-IDF and Cosine Similarity

Purpose:
These techniques are used to identify similar patient cases.

Patient medical records are converted into numerical representations using
TF-IDF. Cosine Similarity is then used to calculate the similarity between
patient records.

Example:

Patient P001
    ↓
Medical history
    ↓
TF-IDF vector
    ↓
Cosine Similarity
    ↓
Similar patient records

## Patient Records

Patient records are stored as individual `.txt` files.

Example:

P001.txt

Patient ID: P001
Name: Ravi Kumar
Age: 45
Gender: Male
Disease: Type 2 Diabetes
Symptoms: Increased thirst, fatigue, frequent urination
Diagnosis: Type 2 Diabetes Mellitus
Prescription: Metformin
Medical History: History of high blood sugar and sedentary lifestyle.

The dataset contains synthetic records created only for academic demonstration.

## How to Run

### Step 1: Open the project

Open the MediSearch folder in VS Code.

### Step 2: Compile

Open the terminal inside the MediSearch folder and run:

javac src\*.java

### Step 3: Run

java -cp src MediSearch

## Main Menu

The application provides options such as:

1. Search Patient Records
2. Display All Records
3. Exit

Additional modules will be added for:

4. Multiple Keyword Search
5. Fuzzy Search
6. Similar Case Identification

## Project Objective

The main objective of Medi Search is to demonstrate how advanced Data
Structures and Algorithms can be applied to efficiently retrieve and compare
medical information stored in text files.

## Team Members

Member 1: S.CAHARAN TEJA REDDY

Member 2: V.HEMANTH

Member 3: K.CHAITANYA

## Technologies

Programming Language:
Java

Development Environment:
VS Code

Data Source:
Synthetic patient text files

Core Concepts:
- String Algorithms
- Pattern Matching
- Trie
- Dynamic Programming
- Text Similarity
- Time and Space Complexity

## Expected Outcome

The project aims to provide efficient patient record retrieval and demonstrate
the practical application of advanced DSA algorithms in a healthcare-related
problem.
