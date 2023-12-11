# -*- coding: utf-8 -*-
"""deploy_1.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1-P3g0ie-rtMSXnWRXqWfzbYzyzNJue0D
"""

pip install Flask tensorflow

from flask import Flask, request, jsonify
import tensorflow as tf
from keras.models import load_model
import re

app = Flask(__name__)

# Memuat model
model = load_model('model_1.h5')

# Preprocessing teks
def preprocess_text(text):
    text = text.lower()
    text = re.sub(r'[^\w\s]', '', text)
    text = re.sub(r'\d+', '', text)
    text = text.strip()
    return text

@app.route('/predict', methods=['POST'])
def predict():
    # Mendapatkan data JSON dari request
    data = request.get_json(force=True)

    # Memastikan data dalam format yang benar
    input_data = preprocess_text(data['input'])

    # Jika model Anda memerlukan input dalam bentuk tertentu (seperti array numpy), lakukan konversi di sini
    # Contoh: input_data = np.array([input_data])

    # Melakukan prediksi
    prediction = model.predict(input_data)

    # Mengirimkan hasil prediksi
    return jsonify({'prediction': prediction.tolist()})

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=5000)