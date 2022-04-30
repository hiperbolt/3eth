import json

def grab(id, client):
    query = "SELECT * FROM `eth-348810.test_dataset.products` WHERE id = {}".format(id)
    query_job = client.query(query)
    rows = query_job.result()
    records = [dict(row) for row in query_job]
    json_obj = json.dumps(str(records))

    return json_obj