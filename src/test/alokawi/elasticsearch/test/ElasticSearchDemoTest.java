/**
 * 
 */
package alokawi.elasticsearch.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHitField;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

/**
 * @author alokkumar
 *
 */
public class ElasticSearchDemoTest {
	public static void main(String[] args) throws UnknownHostException {
		try (@SuppressWarnings("resource")
		TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300))) {
			SearchResponse sr = client.prepareSearch().setQuery(QueryBuilders.matchQuery("message", "myProduct"))
					.addAggregation(AggregationBuilders.terms("top_10_states").field("state").size(10)).execute()
					.actionGet();
			SearchHits hits = sr.getHits();
			for (SearchHit searchHit : hits) {
				for (SearchHitField searchHitField : searchHit) {
					System.out.println(searchHitField.getValues());
				}
			}
		}
	}
}
