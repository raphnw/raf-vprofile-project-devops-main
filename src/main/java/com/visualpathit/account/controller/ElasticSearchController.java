package com.visualpathit.account.controller;

import java.io.IOException;
import java.util.List;
<<<<<<< HEAD

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
=======
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.delete.DeleteResponse;
>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
<<<<<<< HEAD
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
=======
import org.elasticsearch.common.xcontent.XContentBuilder;
>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
<<<<<<< HEAD

=======
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab
import com.visualpathit.account.model.User;
import com.visualpathit.account.service.UserService;
import com.visualpathit.account.utils.ElasticsearchUtil;

<<<<<<< HEAD
@Controller
public class ElasticSearchController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/elasticsearch", method = RequestMethod.GET)
    public String insert(final Model model) throws IOException {
        List<User> users = userService.getList();

        try (RestHighLevelClient client = ElasticsearchUtil.getRestHighLevelClient()) {
            for (User user : users) {
                IndexRequest indexRequest = new IndexRequest("users", "_doc", String.valueOf(user.getId()))
                        .source(XContentFactory.jsonBuilder()
                                .startObject()
                                .field("name", user.getUsername())
                                .field("DOB", user.getDateOfBirth())
                                .field("fatherName", user.getFatherName())
                                .field("motherName", user.getMotherName())
                                .field("gender", user.getGender())
                                .field("nationality", user.getNationality())
                                .field("phoneNumber", user.getPhoneNumber())
                                .endObject());

                IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);
                String res = response.getResult().toString();
                System.out.println(res);
            }
        }

        model.addAttribute("result", "Users indexed successfully");
        return "elasticeSearchRes";
    }

    @RequestMapping(value = "/rest/users/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable final String id, final Model model) throws IOException {
        try (RestHighLevelClient client = ElasticsearchUtil.getRestHighLevelClient()) {
            GetRequest getRequest = new GetRequest("users", "_doc", id);
            GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);

            System.out.println(getResponse.getSourceAsString());
            model.addAttribute("res", getResponse.getSource().get("name"));
        }

        return "elasticeSearchRes";
    }

    @RequestMapping(value = "/rest/users/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable final String id, final Model model) throws IOException {
        try (RestHighLevelClient client = ElasticsearchUtil.getRestHighLevelClient()) {
            UpdateRequest updateRequest = new UpdateRequest("users", "_doc", id)
                    .doc(XContentFactory.jsonBuilder()
                            .startObject()
                            .field("gender", "male")
                            .endObject());

            UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
            System.out.println(updateResponse.status());
            model.addAttribute("res", updateResponse.status());
        }

        return "elasticeSearchRes";
    }

    @RequestMapping(value = "/rest/users/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable final String id, final Model model) throws IOException {
        try (RestHighLevelClient client = ElasticsearchUtil.getRestHighLevelClient()) {
            DeleteRequest deleteRequest = new DeleteRequest("users", "_doc", id);
            DeleteResponse deleteResponse = client.delete(deleteRequest, RequestOptions.DEFAULT);

            System.out.println(deleteResponse.getResult().toString());
            model.addAttribute("res", deleteResponse.getResult().toString());
        }

        return "elasticeSearchRes";
    }
=======
import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

@Controller
public class ElasticSearchController {
	@Autowired
    private UserService userService;
    
    @RequestMapping(value="/user/elasticsearch", method=RequestMethod.GET)
    public String insert(final Model model) throws IOException {
    	List<User> users = userService.getList();
    	//contextMapping();
    	
    	/*	for (User user : users) {
    		//IndexRequest indexRequest = new IndexRequest("users","user",  String.valueOf(user.getId()));
    		//indexRequest.source(new Gson().toJson(user));
    		//IndexResponse response = ElasticsearchUtil.trannsportClient().index(indexRequest).actionGet();
     	   	System.out.println("User" +new Gson().toJson(user));
		}*/
    	String result ="";
    	for (User user : users) {
    	IndexResponse response = ElasticsearchUtil.trannsportClient().prepareIndex("users","user",  String.valueOf(user.getId()))
                .setSource(jsonBuilder()
                        .startObject()
                        .field("name", user.getUsername())
                        .field("DOB",user.getDateOfBirth())
                        .field("fatherName",user.getFatherName())
                        .field("motherName",user.getMotherName())
                        .field("gender",user.getGender())
                        .field("nationality",user.getNationality())
                        .field("phoneNumber", user.getPhoneNumber())
                        .endObject()
                )
                .get();
        String res =response.getResult().toString();
        System.out.println(res);
        result="Users";
    	}
    	model.addAttribute(result);
        return "elasticeSearchRes";
        		
    }

    @RequestMapping(value="/rest/users/view/{id}", method=RequestMethod.GET)
    public String  view(@PathVariable final String id,final Model model) {
        GetResponse getResponse = ElasticsearchUtil.trannsportClient().prepareGet("users", "user", id).get();
        System.out.println(getResponse.getSource());
        
        model.addAttribute("res", getResponse.getSource().get("name"));
       
        return "elasticeSearchRes";
    }
    /*@RequestMapping(value = "/get_user_list",  method = RequestMethod.GET)
    public @ResponseBody List getTagList(@RequestParam("term") String query) {
    	List<User> users = userService.getList();
    	List tagList = null;
    	for (User user : users) {
	    	GetResponse getResponse = ElasticsearchUtil.trannsportClient().prepareGet("users", "user" ,String.valueOf(user.getId())).get();
	        System.out.println(getResponse.getSource());
	        
	        tagList.add(getResponse.getSource());
    	}
        return tagList;
    }*/

    @RequestMapping(value="/rest/users/update/{id}", method=RequestMethod.GET)
    public String update(@PathVariable final String id,final Model model) throws IOException {

        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index("employee")
                .type("id")
                .id(id)
                .doc(jsonBuilder()
                        .startObject()
                        .field("gender", "male")
                        .endObject());
        try {
            UpdateResponse updateResponse = ElasticsearchUtil.trannsportClient().update(updateRequest).get();
            System.out.println(updateResponse.status());
            model.addAttribute("res", updateResponse.status());
            return "elasticeSearchRes";
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
        }
        return "elasticeSearchRes";
    }
    @RequestMapping(value="/rest/users/delete/{id}", method=RequestMethod.GET)
    public String delete(@PathVariable final String id,final Model model) {

        DeleteResponse deleteResponse =ElasticsearchUtil.trannsportClient().prepareDelete("employee", "id", id).get();
        System.out.println(deleteResponse.getResult().toString());
        model.addAttribute("res", deleteResponse.getResult().toString());
        return "elasticeSearchRes";
    }
    /*public void contextMapping() throws IOException{    	   	
		String json ="{"
				+ "\"mappings\":{"
				+ "\"users\":\" {"
				+ "\"properties\" : {"
				+ "\"name\" : { \"type\" : \"string\" },"
				+ " \"city\" : { \"type\" : \"string\" },"
				+ "\"name_suggest\" : {"
				+ "\"type\" :     \"completion\""
				+ "}}"
				+ "}";
		IndexResponse response = ElasticsearchUtil.trannsportClient().prepareIndex("users", "data")
								.setSource(json).execute().actionGet();
		
    }*/
>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab
}
