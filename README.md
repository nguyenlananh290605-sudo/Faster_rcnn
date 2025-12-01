# Faster R-CNN
## Hướng dẫn cài đặt và chạy dự án

### Bước 1: Tải Apache Maven
Truy cập trang chính thức để tải Maven:  
[https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)  

Chọn **Binary zip archive** để tải về.

### Bước 2: Giải nén
Giải nén file vừa tải vào một thư mục trên máy, ví dụ: C:\apache-maven-3.9.6

### Bước 3: Thêm Maven vào PATH
1. Mở **Control Panel → System → Advanced system settings → Environment Variables → PATH**  
2. Thêm đường dẫn Maven `bin` vào PATH:  C:\apache-maven-3.9.6\bin
3. Lưu lại và đóng các cửa sổ.

### Bước 4: Kiểm tra cài đặt
Mở terminal mới và gõ: mvn -v

Nếu terminal hiển thị version của Maven, nghĩa là cài đặt thành công.

### Bước 5: Chạy backend và frontend

#### Chạy backend

- FastAPI: uvicorn app:app --reload TRONG THƯ MỤC Kanggle
- Spring Boot (vào thư mục `backend` chứa `pom.xml`): mvn spring-boot:run

#### Chạy frontend
1. Vào thư mục chứa file `index.html` của frontend.  
2. Mở file `index.html` trên trình duyệt Chrome.

> **Lưu ý:** Đảm bảo backend đã chạy trước khi mở frontend để kết nối API hoạt động.
