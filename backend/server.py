from flask import Flask
from flask_restful import Resource, Api, reqparse
import grabByID, returnPage, menuEntries, searchByTerm, handle_login, validateToken, appTitle
from google.cloud import bigquery

app = Flask(__name__)
api = Api(app)

client = bigquery.Client()

@app.route('/')
def index():
    return "Welcome to 3eth's backend"

@app.route('/api/v1/publicQuery/<id>', methods=['GET'])
def grabID(id):
    return grabByID.grab(id, client)

@app.route('/api/v1/publicQuery/returnPage/<index>/<numElements>', methods=['GET'])
def returnPageByIndex(index, numElements):
    return returnPage.grab(index, numElements, client)

@app.route('/api/v1/publicQuery/<searchTerm>', methods=['GET'])
def searchByTerm(searchTerm):
    return searchByTerm.returnSearchByTerm(client)

@app.route('/api/v1/ui/menuEntries', methods=['GET'])
def returnMenuEntries():
    return menuEntries.returnEntries(client)

@app.route('/api/v1/ui/appTitle', methods=['GET'])
def getAppTitle():
    return appTitle.grab(client)

@app.route('/api/v1/private/getToken/<username>/<password>', methods=['GET'])
def returnAuthToken(username, password):
    return handle_login.loginHandler(client, username, password)

@app.route('/api/v1/private/validateToken', methods=['GET'])
def returnTokenValidation():
    return validateToken.grab(client)


if __name__ == '__main__':
    app.run(debug=True)