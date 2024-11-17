import config.Database;
import repositories.TodoListRepository;
import repositories.TodoListRepositoryDbImpl;
import services.TodoListService;
import services.TodoListServiceImpl;
import views.TodoListTerminalViewImpl;
import views.TodoListView;

public class Main {
    public static void main(String[] args) {

        Database database = new Database("todo_si", "root", "", "localhost", "3306");
        database.setup();

        TodoListRepository todoListRepository = new TodoListRepositoryDbImpl(database);
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListTerminalViewImpl(todoListService);
        todoListView.run();
    }
}