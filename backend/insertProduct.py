from flask import request
import json

def insert(client):
    productName = request.form['productName']
    productBlob = request.form['productBlob']
    productPrice = request.form['productPrice']
    productDescription = request.form['productDescription']
    productCategory = request.form['productCategory']
    productCarbonFootprint = request.form['productCarbonFootprint']
    productEthicallyFarmed = request.form['productEthicallyFarmed']
    productMainEnergySource = request.form['productMainEnergySource']

    query = ('INSERT INTO `eth-348810.test_dataset.products` (productName, productBlob, productPrice, productDescription, productCategory, productCarbonFootprint, productEthicallyFarmed, productMainEnergySource) VALUES (\'' + productName + '\', \'' + productBlob + '\', \'' + productPrice + '\', \'' + productDescription + '\', \'' + productCategory + '\', \'' + productCarbonFootprint + '\', \'' + productEthicallyFarmed + '\', \'' + productMainEnergySource + '\')')

    query_job = client.query(query)
    rows = query_job.result()
    records = [dict(row) for row in query_job]
    json_obj = json.dumps(str(records))
    
    return json_obj