from flask import Flask
from flask_restful import Resource, Api, reqparse
import grabByID
import returnPage
from google.cloud import bigquery

app = Flask(__name__)
api = Api(app)

client = bigquery.Client()

@app.route('/')
def index():
    return '<h1>Hello World!</h1>'

@app.route('/api/v1/publicQuery/<id>', methods=['GET'])
def grabID(id):
    return grabByID.grab(id, client)

@app.route('/api/v1/publicQuery/returnPage/<index>/<numElements>', methods=['GET'])
def returnPageByIndex(index, numElements):
    return returnPage.grab(index, numElements, client)

if __name__ == '__main__':
    app.run(debug=True)