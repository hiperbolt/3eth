def grab(id, client):
    query = "SELECT * FROM 'bigquery-public-data.hacker_news.full' WHERE id = {}".format(id)
    query_job = client.query(query)
    return query_job.result()