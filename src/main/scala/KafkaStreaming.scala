import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.Duration
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.StreamingContext
import com.ibm.cds.spark.samples.config.MessageHubConfig
import com.ibm.cds.spark.samples.dstream.KafkaStreaming.KafkaStreamingContextAdapter

import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.StringDeserializer

object KafkaStreaming {
    def main(args: Array[String]) {
	val sparkConf = new SparkConf().setAppName("Broadcast Test")
        val sc = new SparkContext(sparkConf)	

        val kafkaProps = new MessageHubConfig

	kafkaProps.setConfig("bootstrap.servers", "kafka01-prod01.messagehub.services.us-south.bluemix.net:9093,kafka02-prod01.messagehub.services.us-south.bluemix.net:9093,kafka03-prod01.messagehub.services.us-south.bluemix.net:9093,kafka04-prod01.messagehub.services.us-south.bluemix.net:9093,kafka05-prod01.messagehub.services.us-south.bluemix.net:9093")
	kafkaProps.setConfig("kafka.user.name","8VMHLXchCMZRFfL2")
	kafkaProps.setConfig("kafka.user.password", "n0k4swQy1M8xYOVWTA301Bc9rBZirihh")
	kafkaProps.setConfig("kafka.topic","event_topic")

	kafkaProps.createConfiguration("")


	val ssc = new StreamingContext( sc, Seconds(5) )

	val stream = ssc.createKafkaStream[String, String, StringDeserializer, StringDeserializer](
        	kafkaProps,
	        List("event_topic"));

	stream.print()
	ssc.start()
	ssc.awaitTermination()
    }
  }
