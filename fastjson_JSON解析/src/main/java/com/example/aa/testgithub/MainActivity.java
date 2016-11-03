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
    String data1="[\n" +
            "    {\n" +
            "        \"Id\": \"677b15f0-80f5-460d-b110-de2cff27fc77\",\n" +
            "        \"AppId\": \"24850d67-e430-4d68-9830-8812a13744c5\",\n" +
            "        \"MemberId\": \"b4301a4c-9e35-4b95-8763-b148614457b2\",\n" +
            "        \"MemberLocationId\": \"6252cb6f-9515-4316-93ee-824339c0e61d\",\n" +
            "        \"LocationId\": \"240af6d3-487e-404c-b8b5-7a90620b4310\",\n" +
            "        \"LocationPid\": \"10c8fe8b-2142-449e-a8d0-f7acee0b8e98\",\n" +
            "        \"LocationName\": \"808\",\n" +
            "        \"LocationNumber\": \"0808\",\n" +
            "        \"LocationFullName\": \"联发新天地>1号楼>2单元>808\",\n" +
            "        \"LocationCode\": \"CN-FJ-XM-LFXTD-01-02-0808\",\n" +
            "        \"UnitCode\": \"CN-FJ-XM-LFXTD\",\n" +
            "        \"LocationAccount\": \"CN-FJ-XM-LFXTD-01-02-0808-554433289@121.40.75.178\",\n" +
            "        \"LocationPassword\": \"xmcrtech\",\n" +
            "        \"LocationGroup\": \"3\",\n" +
            "        \"LocationAccountId\": \"3700\",\n" +
            "        \"LocationType\": \"customer\",\n" +
            "        \"LocationGpsOn\": \"0\",\n" +
            "        \"IsGate\": false\n" +
            "    },\n" +
            "    {\n" +
            "        \"Id\": \"12077b19-3664-4f34-b58e-31f6a6336fd5\",\n" +
            "        \"AppId\": \"\",\n" +
            "        \"MemberId\": \"\",\n" +
            "        \"MemberLocationId\": \"\",\n" +
            "        \"LocationId\": \"12077b19-3664-4f34-b58e-31f6a6336fd5\",\n" +
            "        \"LocationPid\": \"1b1ce4a7-f2be-47f1-b762-57c2c7d09f3a\",\n" +
            "        \"LocationName\": \"北门\",\n" +
            "        \"LocationNumber\": \"gate100\",\n" +
            "        \"LocationFullName\": \"联发新天地>北门\",\n" +
            "        \"LocationCode\": \"CN-FJ-XM-LFXTD-gate-100\",\n" +
            "        \"UnitCode\": \"CN-FJ-XM-LFXTD\",\n" +
            "        \"LocationAccount\": \"CN-FJ-XM-LFXTD-gate-100@121.40.75.178\",\n" +
            "        \"LocationPassword\": \"xmcrtech\",\n" +
            "        \"LocationGroup\": \"3\",\n" +
            "        \"LocationAccountId\": \"2759\",\n" +
            "        \"LocationType\": \"gate\",\n" +
            "        \"LocationBlueMac\": \"\",\n" +
            "        \"IsGate\": true\n" +
            "    },\n" +
            "    {\n" +
            "        \"Id\": \"5d3cd8b6-b14e-4bad-9833-a53cc576d748\",\n" +
            "        \"AppId\": \"\",\n" +
            "        \"MemberId\": \"\",\n" +
            "        \"MemberLocationId\": \"\",\n" +
            "        \"LocationId\": \"5d3cd8b6-b14e-4bad-9833-a53cc576d748\",\n" +
            "        \"LocationPid\": \"1b1ce4a7-f2be-47f1-b762-57c2c7d09f3a\",\n" +
            "        \"LocationName\": \"东门\",\n" +
            "        \"LocationNumber\": \"gate-99\",\n" +
            "        \"LocationFullName\": \"联发新天地>东门\",\n" +
            "        \"LocationCode\": \"CN-FJ-XM-LFXTD-gate-99\",\n" +
            "        \"UnitCode\": \"CN-FJ-XM-LFXTD\",\n" +
            "        \"LocationAccount\": \"CN-FJ-XM-LFXTD-gate-99@121.40.75.178\",\n" +
            "        \"LocationPassword\": \"xmcrtech\",\n" +
            "        \"LocationGroup\": \"3\",\n" +
            "        \"LocationAccountId\": \"2724\",\n" +
            "        \"LocationType\": \"gate\",\n" +
            "        \"LocationBlueMac\": \"\",\n" +
            "        \"IsGate\": true\n" +
            "    },\n" +
            "    {\n" +
            "        \"Id\": \"7044ed77-3249-4aa2-a325-710065969325\",\n" +
            "        \"AppId\": \"\",\n" +
            "        \"MemberId\": \"\",\n" +
            "        \"MemberLocationId\": \"\",\n" +
            "        \"LocationId\": \"7044ed77-3249-4aa2-a325-710065969325\",\n" +
            "        \"LocationPid\": \"1b1ce4a7-f2be-47f1-b762-57c2c7d09f3a\",\n" +
            "        \"LocationName\": \"南门\",\n" +
            "        \"LocationNumber\": \"gate-101\",\n" +
            "        \"LocationFullName\": \"联发新天地>南门\",\n" +
            "        \"LocationCode\": \"CN-FJ-XM-LFXTD-gate-101\",\n" +
            "        \"UnitCode\": \"CN-FJ-XM-LFXTD\",\n" +
            "        \"LocationAccount\": \"CN-FJ-XM-LFXTD-gate-101@121.40.75.178\",\n" +
            "        \"LocationPassword\": \"xmcrtech\",\n" +
            "        \"LocationGroup\": \"3\",\n" +
            "        \"LocationAccountId\": \"2851\",\n" +
            "        \"LocationType\": \"gate\",\n" +
            "        \"LocationBlueMac\": \"\",\n" +
            "        \"IsGate\": true\n" +
            "    },\n" +
            "    {\n" +
            "        \"Id\": \"e2d741ad-7884-4a33-8455-ac6ba0ffeb3d\",\n" +
            "        \"AppId\": \"24850d67-e430-4d68-9830-8812a13744c5\",\n" +
            "        \"MemberId\": \"eb15fc98-add3-466a-b79a-1bf25e77489e\",\n" +
            "        \"MemberLocationId\": \"0ae50a48-681e-48c4-bf5c-a2f69d7083ea\",\n" +
            "        \"LocationId\": \"ffdf65b5-4444-4155-a789-bd9de15a9c85\",\n" +
            "        \"LocationPid\": \"984cdc40-8bb7-4cf6-b103-e1266480d4eb\",\n" +
            "        \"LocationName\": \"301\",\n" +
            "        \"LocationNumber\": \"0301\",\n" +
            "        \"LocationFullName\": \"联发新天地>1号楼>3单元>301\",\n" +
            "        \"LocationCode\": \"CN-FJ-XM-LFXTD-01-03-0301\",\n" +
            "        \"UnitCode\": \"CN-FJ-XM-LFXTD\",\n" +
            "        \"LocationAccount\": \"CN-FJ-XM-LFXTD-01-03-0301-554433391@121.40.75.178\",\n" +
            "        \"LocationPassword\": \"xmcrtech\",\n" +
            "        \"LocationGroup\": \"3\",\n" +
            "        \"LocationAccountId\": \"2669\",\n" +
            "        \"LocationType\": \"admin\",\n" +
            "        \"LocationGpsOn\": \"1\",\n" +
            "        \"IsGate\": false\n" +
            "    }\n" +
            "]";
    String appid="{\n" +
            "    \"userid\": \"1111111\",\n" +
            "    \"sessionid\": \"22222\",\n" +
            "    \"username\": \"158254655\",\n" +
            "    \"responsestatus\": {},\n" +
            "    \"mata\": {\n" +
            "        \"intercomtoken\": \"8723895735-23847283\"\n" +
            "    }\n" +
            "}";

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
            appid appidresult = JSON.parseObject(appid,new TypeReference<appid>(){});
        textView.setText(appidresult.toString());


    }
}
