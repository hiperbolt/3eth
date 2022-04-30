def returnEntries(client):
    query = (
        'SELECT * FROM `bigquery-public-data.hacker_news.full` '
    )
    query_job = client.query(query)
    rows = query_job.result()
    return rows