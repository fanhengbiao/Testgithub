package com.example.aa.testgithub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    String data="{\n" +
            "    \"PageCount\": 18,\n" +
            "    \"UnReadCount\": 129,\n" +
            "    \"Messages\": [\n" +
            "        {\n" +
            "            \"MessageID\": \"da619748-8974-401d-af31-9230390d4b7d\",\n" +
            "            \"MessageName\": \"来自联发新天地>1号楼>2单元>808的紧急呼救\",\n" +
            "            \"MessageContent\": \"来自联发新天地>1号楼>2单元>808的紧急呼救\",\n" +
            "            \"MessageType\": \"SOS\",\n" +
            "            \"AppID\": \"24850d67-e430-4d68-9830-8812a13744c5\",\n" +
            "            \"MemberID\": \"d32edfc9-f61a-4544-b9da-aed7916d3288\",\n" +
            "            \"UserName\": \"\",\n" +
            "            \"MessageIsRead\": \"1\",\n" +
            "            \"CreateTime\": \"2016年9月22日\",\n" +
            "            \"CreateBy\": \"d715fe41-719d-445e-81b2-e33308abe256\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"MessageID\": \"ce81dd85-c4d3-429a-bf40-450c1536439f\",\n" +
            "            \"MessageName\": \"来自联发新天地>1号楼>2单元>808的紧急呼救\",\n" +
            "            \"MessageContent\": \"来自联发新天地>1号楼>2单元>808的紧急呼救\",\n" +
            "            \"MessageType\": \"SOS\",\n" +
            "            \"AppID\": \"24850d67-e430-4d68-9830-8812a13744c5\",\n" +
            "            \"MemberID\": \"d32edfc9-f61a-4544-b9da-aed7916d3288\",\n" +
            "            \"UserName\": \"\",\n" +
            "            \"MessageIsRead\": \"1\",\n" +
            "            \"CreateTime\": \"2016年8月31日\",\n" +
            "            \"CreateBy\": \"d715fe41-719d-445e-81b2-e33308abe256\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"MessageID\": \"f692766b-0b5d-4579-aef0-c20f42f1a221\",\n" +
            "            \"MessageName\": \"来自联发新天地>1号楼>2单元>808的紧急呼救\",\n" +
            "            \"MessageContent\": \"来自联发新天地>1号楼>2单元>808的紧急呼救\",\n" +
            "            \"MessageType\": \"SOS\",\n" +
            "            \"AppID\": \"24850d67-e430-4d68-9830-8812a13744c5\",\n" +
            "            \"MemberID\": \"8ad37a0c-01d8-4a33-a1b0-bd223a50a667\",\n" +
            "            \"UserName\": \"\",\n" +
            "            \"MessageIsRead\": \"1\",\n" +
            "            \"CreateTime\": \"2016年7月28日\",\n" +
            "            \"CreateBy\": \"835b63ab-572d-44d6-a87d-775979b32b8f\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"MessageID\": \"4fd5aab2-81cb-47ba-a655-3b4edc864dcc\",\n" +
            "            \"MessageName\": \"来自联发新天地>1号楼>2单元>808的紧急呼救\",\n" +
            "            \"MessageContent\": \"来自联发新天地>1号楼>2单元>808的紧急呼救\",\n" +
            "            \"MessageType\": \"SOS\",\n" +
            "            \"AppID\": \"24850d67-e430-4d68-9830-8812a13744c5\",\n" +
            "            \"MemberID\": \"8ad37a0c-01d8-4a33-a1b0-bd223a50a667\",\n" +
            "            \"UserName\": \"\",\n" +
            "            \"MessageIsRead\": \"1\",\n" +
            "            \"CreateTime\": \"2016年7月28日\",\n" +
            "            \"CreateBy\": \"835b63ab-572d-44d6-a87d-775979b32b8f\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"MessageID\": \"82be2e7c-a0ac-4dc1-94eb-b018bfbf5a81\",\n" +
            "            \"MessageName\": \"来自联发新天地>1号楼>2单元>808的紧急呼救\",\n" +
            "            \"MessageContent\": \"来自联发新天地>1号楼>2单元>808的紧急呼救\",\n" +
            "            \"MessageType\": \"SOS\",\n" +
            "            \"AppID\": \"24850d67-e430-4d68-9830-8812a13744c5\",\n" +
            "            \"MemberID\": \"8ad37a0c-01d8-4a33-a1b0-bd223a50a667\",\n" +
            "            \"UserName\": \"\",\n" +
            "            \"MessageIsRead\": \"1\",\n" +
            "            \"CreateTime\": \"2016年7月28日\",\n" +
            "            \"CreateBy\": \"835b63ab-572d-44d6-a87d-775979b32b8f\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"MessageID\": \"77592a85-5c7b-4f96-9956-467216043627\",\n" +
            "            \"MessageName\": \"来自联发新天地>1号楼>2单元>808的紧急呼救\",\n" +
            "            \"MessageContent\": \"来自联发新天地>1号楼>2单元>808的紧急呼救\",\n" +
            "            \"MessageType\": \"SOS\",\n" +
            "            \"AppID\": \"24850d67-e430-4d68-9830-8812a13744c5\",\n" +
            "            \"MemberID\": \"8ad37a0c-01d8-4a33-a1b0-bd223a50a667\",\n" +
            "            \"UserName\": \"\",\n" +
            "            \"MessageIsRead\": \"1\",\n" +
            "            \"CreateTime\": \"2016年7月28日\",\n" +
            "            \"CreateBy\": \"835b63ab-572d-44d6-a87d-775979b32b8f\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"MessageID\": \"b836091e-f343-403c-891a-e44061e6d2dd\",\n" +
            "            \"MessageName\": \"来自联发新天地>1号楼>2单元>808的紧急呼救\",\n" +
            "            \"MessageContent\": \"来自联发新天地>1号楼>2单元>808的紧急呼救\",\n" +
            "            \"MessageType\": \"SOS\",\n" +
            "            \"AppID\": \"24850d67-e430-4d68-9830-8812a13744c5\",\n" +
            "            \"MemberID\": \"47694268-e49d-4dd7-a979-cd294de5ec3a\",\n" +
            "            \"UserName\": \"\",\n" +
            "            \"MessageIsRead\": \"1\",\n" +
            "            \"CreateTime\": \"2016年7月26日\",\n" +
            "            \"CreateBy\": \"2b9d5301-38c3-4857-bf87-fccdfce72fe2\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"MessageID\": \"99516029-ec4b-4868-902b-7fe2ab57a69e\",\n" +
            "            \"MessageName\": \"来自联发新天地>1号楼>3单元>301的紧急呼救\",\n" +
            "            \"MessageContent\": \"来自联发新天地>1号楼>3单元>301的紧急呼救\",\n" +
            "            \"MessageType\": \"SOS\",\n" +
            "            \"AppID\": \"24850d67-e430-4d68-9830-8812a13744c5\",\n" +
            "            \"MemberID\": \"d32edfc9-f61a-4544-b9da-aed7916d3288\",\n" +
            "            \"UserName\": \"\",\n" +
            "            \"MessageIsRead\": \"1\",\n" +
            "            \"CreateTime\": \"2016年7月25日\",\n" +
            "            \"CreateBy\": \"2f9efa21-19ca-4d67-a443-249dbc4594e6\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"MessageID\": \"14ba1d36-299d-4e88-90bf-b7334098e1e1\",\n" +
            "            \"MessageName\": \"来自联发新天地>1号楼>2单元>808的紧急呼救\",\n" +
            "            \"MessageContent\": \"来自联发新天地>1号楼>2单元>808的紧急呼救\",\n" +
            "            \"MessageType\": \"SOS\",\n" +
            "            \"AppID\": \"24850d67-e430-4d68-9830-8812a13744c5\",\n" +
            "            \"MemberID\": \"99539fc9-ab68-4846-a827-d18f7bd9f61b\",\n" +
            "            \"UserName\": \"\",\n" +
            "            \"MessageIsRead\": \"1\",\n" +
            "            \"CreateTime\": \"2016年6月15日\",\n" +
            "            \"CreateBy\": \"6602da68-4f3e-4c57-92a3-a282b975d482\"\n" +
            "        },\n" +
            "        ]\n" +
            "}\n";

    /**fastjson解析非常方便,实体类直接用JSONFomat来做,直接这样就好 personal list = JSON.parseObject(data,new TypeReference<personal>(){});
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fastJson();
            }
        });
    }

    /**
     *
     */
    public void fastJson(){
        personal list = JSON.parseObject(data,new TypeReference<personal>(){});
        textView.setText(list.toString());


    }
}
