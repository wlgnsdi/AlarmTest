# AlarmManager 를 활용한 알람 기능 구현
### 1. 목적
AlarmManager를 활용해서 간단 알람+진동 구현 테스트
### 2. 구조   

```bash
app
 │ MyApplication.kt
 │
 ├── activity(생략)
 ├── utils
 │    ├── NotificationHandler
 │    │ 
 │    └── alarm
 │         ├── AlarmHandler
 │         ├── AlarmReceiver
 │         ├── AlarmService
 │         └── BootReceiver(미구현)
```

### 3. 알람 흐름
1. App 실행시, Application 에서 NotificationChannel 등록 (실행할때 등록 안해도 되고 알람을 등록할때 해도 무방하다)
2. 시간에 맞춰서 동작을 원하면 시간을 받아오고 AlarmHandler 로 시간을 넘겨서 **AlarmManager** 에 **AlarmReceiver**를 등록한다.
3. AlarmReceiver 는 Service 를 상속받은 AlarmService 를 실생시킨다.
4. **AlarmService**에서 Notification 을 띄운다.
