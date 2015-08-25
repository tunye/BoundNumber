# BoundNumber
仿照支付宝金额显示的TextView。数字从0跳跃显示至指定金额。

# 为什么制作这一控件
一直都想在github上制作自己的控件，从最简单的textview动画入手，制作了仿支付宝数字显示的控件。

# How to use it
第一次上传代码至jcenter，生成的链接有些粗糙……<br />  
compile 'com.buaa.ct:app:1.0'

# Demo
### layout
        <com.ct.boundnumber.RiseNumberTextView 
            android:id="@+id/number1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center_horizontal"
            android:layout_marginTop="15dp"
            android:textColor="#000000"
            android:textSize="20sp" />
### Activity
        number1 = (RiseNumberTextView) findViewById(R.id.number1);
        number1.withNumber(1112.3f).start();

###app

[Go to download](http://nj02all01.baidupcs.com/file/cb73e3d39ebc0c16ca7d509767f17311?bkt=p2-nj02-416&fid=789692256-250528-419161849448989&time=1440492041&sign=FDTAXGERLBH-DCb740ccc5511e5e8fedcff06b081203-Tz2wC9Yj7YTHFfK0nYcOktDpGfk%3D&to=nj2hb&fm=Nan,B,U,nc&sta_dx=1&sta_cs=0&sta_ft=apk&sta_ct=0&fm2=Nanjing02,B,U,nc&newver=1&newfm=1&secfm=1&flow_ver=3&pkey=1400cb73e3d39ebc0c16ca7d509767f1731136edd67e00000010c142&sl=74973263&expires=8h&rt=pr&r=639441010&mlogid=3245445950&vuk=789692256&vbdid=2485537476&fin=boundnumber.apk&fn=boundnumber.apk&slt=pm&uta=0&rtype=1&iv=0&isw=0)<br />  

# About me

A student in mainland China.

Welcome to offer me an internship. If you have any new idea about this project, feel free to contact me. :smiley:
