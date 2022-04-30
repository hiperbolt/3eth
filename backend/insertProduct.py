from flask import request

def insert(client):
    form = request.form
    print(form)