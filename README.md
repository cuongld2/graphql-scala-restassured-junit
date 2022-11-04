This example test use GitHub GraphQL API for demonstrating how to work with GraphQL endpoint using Scala and RestAssured.
Please get your own token (classic token), in order to use in the test. Below is the screenshot for the token classic page.

![Token page](https://i.imgur.com/T6ChJKo.png)

The example of the test as below:

```scala

import java.util
import io.restassured.RestAssured.{`given`, given}
import io.restassured.http.ContentType
import io.restassured.module.scala.RestAssuredSupport.AddThenToResponse
import org.junit.Test

class GraphQLSpec {
  private val url = "https://api.github.com/"
  private val endpoint = "graphql"

  @Test def crudTest(): Unit = {

    val githubToken = "your_github_token" // Your classic github token
    val queryText = "query{  viewer {    repositories(first: 100) {      totalCount      nodes {        nameWithOwner      }      pageInfo {        endCursor        hasNextPage      }    }  }}"
    
    val query = new GraphQLQuery
    query.setQuery(queryText)
    val response = `given`().contentType(ContentType.JSON).header("Authorization","bearer "+githubToken).body(query).when().post(url+endpoint)
    println(response.body().prettyPrint())
    println(response.statusCode())
  }
}

```
This example was tested using IntelliJIDEA with JDK 11, scala version 3.2.1 and sbt version 1.7.3