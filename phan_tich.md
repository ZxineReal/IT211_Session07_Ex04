| Tiêu chí | @RestControllerAdvice | @AfterThrowing |
|----------|----------------------|----------------|
| Phạm vi hoạt động | Tầng Controller - Toàn bộ ứng dụng | Tầng Service/Any - Method cụ thể |
| Khả năng can thiệp đổi cấu trúc JSON | Có - Có thể tùy chỉnh hoàn toàn response body, status code, headers | Không - Vì nó không trả về HTTP response |
| Khả năng ghi log ngầm | Có thể nhưng làm rối trách nhiệm (SRP) | Tối ưu - Tách biệt log khỏi business logic |
| Tiếp cận request context | Dễ dàng qua HttpServletRequest | Khó - Cần dùng RequestContextHolder |
| Chặn exception trước khi đến client | Có - Hoạt động như global exception handler | Không - Exception vẫn có thể propagate lên |
| Ném lại exception | Không cần - Đã xử lý triệt để | Thường ném lại hoặc chuyển đổi |
| AOP type | Spring Web Advice (không phải AOP thuần túy) | Spring AOP (AfterThrowing advice) |
| Performance | Nhẹ, chỉ chạy khi có exception từ Controller | Nhẹ, dùng proxy CGLIB/JDK |
| Mục đích chính | Xử lý HTTP Response, trả JSON chuẩn cho Client | Audit logging, ghi log nội bộ debug |
| Vị trí đặt | Tầng Web/Presentation | Tầng Service/Business |
| Khả năng truy cập tham số method | Giới hạn - Chỉ qua Exception object | Đầy đủ - Có thể truy cập JoinPoint để lấy arguments |
| Phụ thuộc vào Spring Web | Bắt buộc | Không bắt buộc |
