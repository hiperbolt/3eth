def returnPage(index, numElements, client):
    query = (
        'SELECT * FROM `bigquery-public-data.hacker_news.full` LIMIT ' + str(numElements) + ' OFFSET ' + str(index)
    )
    query_job = client.query(query)
    rows = query_job.result()
    return rows