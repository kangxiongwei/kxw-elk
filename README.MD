##ELK工程

###一、LogStash收集logback日志

配置文件：
```markdown
1.tcp配置文件
input {
    tcp {
        port => 4560
        codec => json_lines
    }
}

output {
    stdout { codec => rubydebug }
}

2.file配置文件
input {
    file {
        path => "/Users/kangxiongwei/JavaSoft/workspace/ELK/logs/elk.log"
    }
}

output {
    stdout { codec => rubydebug }
}

```

###二、FileBeats收集日志到LogStash中

配置文件：
```mardown
1.logstash配置文件
input {
  beats {
    port => 5044
  }
}
output {
    stdout { codec => rubydebug }
}

2.filebeats配置文件filebeats.yml
- input_type: log
  paths:
    - /Users/kangxiongwei/JavaSoft/workspace/kangxiongwei/ELK/logs/*.log
output.logstash:
  hosts: ["localhost:5004"]
```

启动方法：
```mardown

1.启动logstash
logstash -f xxxx.conf

2.启动filebeats
filebeats -e -c filebeats.yml
```

###三、LogStash将数据存入ElasticSearch，并使用Kibana展示
```mardown

1.logstash配置
input {
  beats {
    port => 5044
  }
}
output {
    stdout { codec => rubydebug }
    elasticsearch {
        hosts => ["127.0.0.1:9200"]
        index => "logstash-elk-%{+YYYY.MM.dd}"
    }
}

2.启动es，使用localhost:9200验证是否启动成功

3.启动kibana，使用localhost:5601验证，然后创建index规则，查看数据

```


