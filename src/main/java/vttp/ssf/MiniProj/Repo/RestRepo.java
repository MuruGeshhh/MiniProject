/*package vttp.ssf.MiniProj.Repo;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import vttp.ssf.MiniProj.Models.RestModel;

@Repository
public class RestRepo{

   
       @Qualifier("redislab")

        @Autowired
        private RedisTemplate<String, String> redisTemplate;
    
        public void save(RestModel movie) {
            redisTemplate.opsForValue().set(movie.getTitle(), movie.toJson().toString());
            redisTemplate.expire(movie.getTitle(), Duration.ofMinutes(5));
        }
    
        public void save(List<RestModel> movie) {
            Map<String, String> map = new HashMap<>();
            for (RestModel res: movie)
                map.put(res.getTitle(), res.toJson().toString());
            redisTemplate.opsForValue().multiSet(map);
    
            for (String id: map.keySet())
                redisTemplate.expire(id, Duration.ofMinutes(5));
        }
    
        public Optional<RestModel> get(String id) {
            if (!redisTemplate.hasKey(id))
                return Optional.empty();
            String data = redisTemplate.opsForValue().get(id);
            return Optional.of(RestModel.create(data));
        }
    }











*/












