import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class RedisClient {

	JedisCluster jedisCluster;

	String host = "pricing-override-redis.alpha.aws.cwan.io";
	int port = 6379;
	int timeoutSec = 90;

	private void startRedisClient() {
		jedisCluster = new JedisCluster(new HostAndPort(host, port), timeoutSec);
		//jedisCluster = new JedisCluster(
	}

	private void stopRedisClient() {
		jedisCluster.close();
	}

	public static void main(String[] args) throws InterruptedException {
		RedisClient redisClient = new RedisClient();
		redisClient.startRedisClient();
		
		Thread.currentThread().sleep(10000);
		
		redisClient.stopRedisClient();

	}

}
