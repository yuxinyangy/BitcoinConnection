package com.btc.rpc.demo;

import com.alibaba.fastjson.JSONObject;

public class JSONDemo {
    public static void main(String[] args) {
        //fastjson的使用方法
        //学生:学号,姓名,性别,年龄

        Student student = new Student();
        student.id = "10001";
        student.name = "lty";
        student.sex = "v";
        student.age = 18;

        //序列化后的对象字符串
        String stuJson = JSONObject.toJSON(student).toString();
        System.out.println(stuJson);

        //反序列化变成内存对象
        Student stu1 = JSONObject.parseObject(stuJson, Student.class);
        System.out.println(stu1.getName());

        //2、利用JsonObject直接生成
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "lty");
        jsonObject.put("sex", "女");
        jsonObject.put("age", "18");
        jsonObject.put("id", "1001");
        String jsonString = jsonObject.toJSONString();
        System.out.println(jsonString);

    }

    static class Student {
        private String id;
        private String name;
        private String sex;
        private int age;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
