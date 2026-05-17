1. Создать класс model.Task
    ```java
    public class Task {
        private Long id;
        private String title;  // название
        private String description; // описание
        private Employee owner; // владелец задачи
        private Employee assigned; // исполнитель задачи
        private LocalDateTime createdAt; // когда была создана
        private LocalDateTime startedWorkAt; // когда была начата работа по задаче
        private TaskStatus status;
        private TaskPriority priority;
    }     
    ```
2. Создать enum TaskStatus
    ```java
    public enum TaskStatus {
        NEW, IN_LINE, IN_WORK, TESTING, CLOSED
    }
    ```

3. Создать enum TaskPriority
    ```java
    public enum TaskPriority {
        LOW, NORMAL, HIGH, SPECIAL
    }
    ```
   
4. Создать контроллер, сервис

---
### Список эндпойнтов

1. `POST /tasks` - создание задачи
    - условия:
      - можно указывать сразу `assigned` - в таком случае инициализируете `startedWorkAt` на текущее время
      - если `assigned` не был указан -  `startedWorkAt` не будет инициализирован
    - тело запроса
    ```json
    {
        "title": "string",
        "description": "string",
        "owner": {
           "id": 1
        },
        "assigned": {
          "id": 2
        },
        "priority": "NORMAL"
    }
    ```
   - тело ответа
    ```json
    {
        "id": 1,
        "title": "string",
        "description": "string",
        "owner": {
           "id": 1
        },
        "assigned": {
          "id": 2
        },
        "priority": "NORMAL",
        "createdAt": "2026-01-01T15:30",
        "startedWorkAt": "2026-01-01T15:30",
        "status": "NEW"
    }
    ```
2. `GET /tasks` - Получение списка задач
3. `GET /tasks/{id}` - Получение задачи по id
4. `PUT /tasks` - Обновление задачи
   - условия
     - нельзя обновлять: `owner`, `createdAt`, `id`
     - можно обновить: `title`, `description`, `assigned`, `priority`, `startedWorkAt`, `status`
   - тело запроса
   ```json
   {
       "id": 1,
       "title": "NEW TITLE",
       "description": "NEW DESCRIPTION",
       "assigned": {
         "id": 6
       },
       "priority": "LOW",
       "startedWorkAt": "2026-01-01T15:30",
       "status": "IN_WORK"
   }
   ```
   - тело ответа
   ```json
   {
       "id": 1,
       "title": "NEW TITLE",
       "description": "NEW DESCRIPTION",
       "owner": {
          "id": 1
       },
       "assigned": {
         "id": 6
       },
       "priority": "LOW",
       "createdAt": "2026-01-01T15:30",
       "startedWorkAt": "2026-01-01T15:30",
       "status": "IN_WORK"
   }
   ```

