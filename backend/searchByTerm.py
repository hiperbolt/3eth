def returnSearchByTerm(searchTerm, client):
    query = (
        'SELECT * FROM `bigquery-public-data.hacker_news.full` WHERE title LIKE \'%' + searchTerm + '%\' OR text LIKE \'%' + searchTerm + '%\''
    )
    query_job = client.query(query)
    rows = query_job.result()
    return rows