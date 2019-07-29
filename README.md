# 說明文件

### install

    mvn clear install

下載所需要的lib

### launch

    src/main/kotlin/com/example/starter/main.kt

使用IDE時(我使用IntelliJ)執行此檔案即可
亦或是透過maven打包成jar檔執行

執行前需確認已安裝mongoDB

### api說明

url:lcoalhost:9000/car/add

input:

    {
      "brand":"yamaha",
      "color":"blue",
      "city":"taipei"
    }

### 自行測試

送出一千個需求

處理時間約在0.6~1.1秒鐘完成

在play-mariadb中要 約落在 0.9~2.2秒之間 (也有落在這範圍之外 更快或更慢)

在vertx-mongo (no corountine)中要 0.6~1.2間

也許是測試api行為單純 沒有太多邏輯的處理,所以可能比較不出來效能上的差異
一開始進行測試時多數資料都在insert,所以時間比較久,多測幾次之後時間偏向穩定(update)

另外在腳本當中尚未紀錄成功與否,所以是需要改進的部分

壓測腳本 -> https://github.com/flameDH/otterPostTest-StressTest-script

play-mariadb -> https://github.com/flameDH/otterTest

vertx restful -> https://github.com/flameDH/vertx-block
