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

