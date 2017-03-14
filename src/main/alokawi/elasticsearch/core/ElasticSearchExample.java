/**
 * 
 */
package alokawi.elasticsearch.core;

import java.io.IOException;

/**
 * @author alokkumar
 *
 */
public class ElasticSearchExample {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ElasticSearchExample elasticSearchExample = new ElasticSearchExample();
		elasticSearchExample.createIndex();
		elasticSearchExample.indexData();
		elasticSearchExample.searchQuery();
		elasticSearchExample.aggregateQuery();

	}

	private void aggregateQuery() {

	}

	private void searchQuery() {

	}

	private void indexData() {

	}

	private void createIndex() throws IOException {
		ElasticSearchIndexManager elasticSearchIndexManager = new ElasticSearchIndexManager();
		elasticSearchIndexManager.prepareIndex();
	}

}
