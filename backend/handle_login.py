from passlib.hash import pbkdf2_sha256
import bcrypt
import jwt
from datetime import datetime, timedelta
import config
from flask import request

def loginHandler(client, username, password):
    response = {
        "success" : False,
        "message" : "Invalid parameters",
        "token" : ""
    }

    if not username or not password:
        return response

    query = ('SELECT hash_, salt FROM `eth-348810.test_dataset.credentials` WHERE username = \'' + username + '\'')
    query_job = client.query(query)
    rows = query_job.result()
    for row in rows: # There should always be only one row, since usernames are unique
        hash = row[0]
        salt = row[1]
        print("password: " + password)

    byted_salt = str.encode(salt)
    calculated_hash = pbkdf2_sha256.encrypt(password, rounds=config.iterations, salt=byted_salt)
    print("hash: " + hash + " calculated_hash: " + calculated_hash + " salt: " + salt)
    if hash == calculated_hash:
            response["success"] = True
    
    if not response["success"]:
        response["message"] = "Unauthorized"
        return response

    #If the login was sucessful, we generate a token.

    response["token"] = jwt.encode({
                'username': username,
                'exp': datetime.utcnow() + timedelta(minutes=30)
            }, config.SECRET_KEY)

    response["message"] = "OK"
    response["success"] = True

    return response

