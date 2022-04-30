from urllib import response
from flask import request
import config
import jwt
import datetime

def grab(client):
    response = {
        "success" : False,
        "message" : "Unauthorized Access!",
        "code" : 401
    }
    token = None

    if 'x-authorization' in request.headers:
        token = request.headers['x-authorization']
    if not token:
        return response

    try:
        data = jwt.decode(token, config.SECRET_KEY)
        query = ('SELECT hash_, salt FROM `eth-348810.test_dataset.credentials` WHERE username = \'' + data['username'] + '\'')
        query_job = client.query(query)
        rows = query_job.result()
        if data['exp'] < datetime.utcnow():
            for row in query:
                response['success']

    except:
        return response