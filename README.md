# Machine Learning 
The application of machine learning on Jobamate, namely a recommendation system displayed on the user's home page based on a questionnaire filled in by the user himself and also the search engine system. 
<br>

# Recommendation System Based on Filling Out The Questionnaire
This recommendation system based on filling in the questionnaire by the user will display jobs in user's dashboard that match the answers to the questionnaire filled in by the user. We already trying various model to fit in our expectation. Here is the our final model for recommendation system based on questionnaire filled in by the user : https://colab.research.google.com/drive/15R63yBNSz0kYTKOy48URsLY23LbGlTo9?usp=sharing#scrollTo=yPBFeaQRRvwg
Here are our steps :
1. We create a dataset (by ourselves) that consist of jobs for disabilities. The dataset contains "Nama Pekerjaan", "Nama Perusahaan", "Tanggal Posting", "Eligibility", "Kondisi", "Audiens", "Tanggal Mulai", "Lokasi", "Job Description", "Job Requirement", "Gaji", "Informasi Perusahaan", "Keahlian", dan "Target_Cocok". Here is the dataset : https://github.com/ghivalzahrvnsyah/Jobamate/blob/machinelearning/modified_set_kerja.csv
2. Then, we installing some required libraries and starting jump to pre-processing step. 
3. After pre-processing is complete, the next step is modeling and training it until get satisfying accuracy and low loss. 
4. We also  try the model by creating drop down settings using widgets from Python. In experiment that we trying, we make location dropdown, skill dropdown, and type of disabilities drop down. Here are the results without using TensorFlow : https://colab.research.google.com/drive/1h9YhZeJO7HbnZqchawn6pTm-LPkGD_BB?usp=sharing#scrollTo=qI99Y9EXjAap
<br>

# Search Engine
This recommendation system based on keyword that search out by user in application. 
Here are our steps : 
1. We create a dataset (by ourselves) that consist of jobs for disabilities. The dataset contains "Nama Pekerjaan", "Nama Perusahaan", "Tanggal Posting", "Eligibility", "Kondisi", "Audiens", "Tanggal Mulai", "Lokasi", "Job Description", "Job Requirement", "Gaji", "Informasi Perusahaan", "Keahlian", dan "Target_Cocok". Here is the dataset : https://github.com/ghivalzahrvnsyah/Jobamate/blob/machinelearning/modified_set_kerja.csv
2. Then, we installing some required libraries and starting jump to pre-processing step. 
3. After pre-processing is complete, the next step is modeling and training it until get satisfying accuracy and low loss. 
<br>
