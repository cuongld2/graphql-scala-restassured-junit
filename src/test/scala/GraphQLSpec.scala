
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
