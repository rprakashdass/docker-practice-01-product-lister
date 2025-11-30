package com.prakash.product_lister;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "<!DOCTYPE html>" +
                "<html lang='en'>" +
                "<head>" +
                "    <meta charset='UTF-8'>" +
                "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                "    <title>Docker & Docker Compose Learning Guide</title>" +
                "    <style>" +
                "        body {" +
                "            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;" +
                "            background-color: #f4f4f4;" +
                "            margin: 0;" +
                "            padding: 20px;" +
                "            line-height: 1.6;" +
                "        }" +
                "        .container {" +
                "            max-width: 1000px;" +
                "            margin: 0 auto;" +
                "            background-color: #fff;" +
                "            padding: 30px;" +
                "            border-radius: 8px;" +
                "            box-shadow: 0 2px 10px rgba(0,0,0,0.1);" +
                "        }" +
                "        h1 {" +
                "            color: #00405d;" +
                "            text-align: center;" +
                "            border-bottom: 3px solid #00405d;" +
                "            padding-bottom: 15px;" +
                "        }" +
                "        .intro {" +
                "            background-color: #e7f3fe;" +
                "            padding: 15px;" +
                "            border-left: 4px solid #00405d;" +
                "            margin-bottom: 20px;" +
                "        }" +
                "        .accordion {" +
                "            background-color: #fff;" +
                "            color: #333;" +
                "            cursor: pointer;" +
                "            padding: 18px;" +
                "            width: 100%;" +
                "            text-align: left;" +
                "            border: 1px solid #ddd;" +
                "            outline: none;" +
                "            transition: 0.4s;" +
                "            margin-top: 5px;" +
                "            font-size: 16px;" +
                "            font-weight: bold;" +
                "            border-radius: 5px;" +
                "        }" +
                "        .active, .accordion:hover {" +
                "            background-color: #e7f3fe;" +
                "        }" +
                "        .panel {" +
                "            padding: 0 18px;" +
                "            background-color: white;" +
                "            max-height: 0;" +
                "            overflow: hidden;" +
                "            transition: max-height 0.2s ease-out;" +
                "            border-left: 1px solid #ddd;" +
                "            border-right: 1px solid #ddd;" +
                "        }" +
                "        code {" +
                "            background-color: #f4f4f4;" +
                "            padding: 2px 6px;" +
                "            border-radius: 3px;" +
                "            font-family: 'Courier New', monospace;" +
                "            color: #c7254e;" +
                "        }" +
                "        pre {" +
                "            background-color: #2d2d2d;" +
                "            color: #f8f8f2;" +
                "            padding: 15px;" +
                "            border-radius: 5px;" +
                "            overflow-x: auto;" +
                "            font-family: 'Courier New', monospace;" +
                "        }" +
                "        ul {" +
                "            margin: 10px 0;" +
                "        }" +
                "        li {" +
                "            margin: 8px 0;" +
                "        }" +
                "        .highlight {" +
                "            background-color: #fff3cd;" +
                "            padding: 10px;" +
                "            border-left: 4px solid #ffc107;" +
                "            margin: 10px 0;" +
                "        }" +
                "    </style>" +
                "</head>" +
                "<body>" +
                "    <div class='container'>" +
                "        <h1>🐳 Docker & Docker Compose Learning Guide</h1>" +
                "        <div class='intro'>" +
                "            <p><strong>What I Learned:</strong> This guide documents my journey building a containerized Spring Boot application with PostgreSQL. " +
                "            I learned how to create Dockerfiles, manage multi-container applications with Docker Compose, configure networking between containers, " +
                "            persist data with volumes, and troubleshoot common issues.</p>" +
                "        </div>" +
                "" +
                "        <button class='accordion'>🏗️ Dockerfile Fundamentals</button>" +
                "        <div class='panel'>" +
                "            <h3>What is a Dockerfile?</h3>" +
                "            <p>A Dockerfile is a text file containing instructions to build a Docker image. Each instruction creates a layer in the image.</p>" +
                "            <h4>Key Instructions:</h4>" +
                "            <ul>" +
                "                <li><code>FROM</code> - Base image to build upon (e.g., <code>FROM openjdk:22-jdk</code>)</li>" +
                "                <li><code>WORKDIR</code> - Sets working directory inside container</li>" +
                "                <li><code>COPY</code> / <code>ADD</code> - Copy files from host to container</li>" +
                "                <li><code>RUN</code> - Execute commands during build (install packages, etc.)</li>" +
                "                <li><code>EXPOSE</code> - Document which port the container listens on</li>" +
                "                <li><code>CMD</code> / <code>ENTRYPOINT</code> - Command to run when container starts</li>" +
                "            </ul>" +
                "            <h4>Example Dockerfile (Spring Boot):</h4>" +
                "            <pre>FROM openjdk:22-jdk\n" +
                "ADD target/product-lister-0.0.1-SNAPSHOT.jar product-lister-0.0.1.jar\n" +
                "ENTRYPOINT [\"java\", \"-jar\", \"/product-lister-0.0.1.jar\"]</pre>" +
                "            <div class='highlight'>" +
                "                <strong>Key Lesson:</strong> Always build your JAR file with <code>mvn package</code> BEFORE building the Docker image!" +
                "            </div>" +
                "        </div>" +
                "" +
                "        <button class='accordion'>🐋 Docker Commands Essentials</button>" +
                "        <div class='panel'>" +
                "            <h3>Image Management</h3>" +
                "            <ul>" +
                "                <li><code>docker build -t &lt;name&gt;:&lt;tag&gt; .</code> - Build image from Dockerfile in current directory</li>" +
                "                <li><code>docker images</code> or <code>docker image ls</code> - List all images</li>" +
                "                <li><code>docker rmi &lt;image-id&gt;</code> - Remove an image</li>" +
                "                <li><code>docker tag &lt;source&gt; &lt;target&gt;</code> - Tag an image</li>" +
                "                <li><code>docker push &lt;image&gt;</code> - Push image to registry (Docker Hub)</li>" +
                "                <li><code>docker pull &lt;image&gt;</code> - Pull image from registry</li>" +
                "            </ul>" +
                "            <h3>Container Management</h3>" +
                "            <ul>" +
                "                <li><code>docker run &lt;image&gt;</code> - Create and start a container</li>" +
                "                <li><code>docker run -d</code> - Run in detached mode (background)</li>" +
                "                <li><code>docker run -p 8080:8080</code> - Map host port to container port</li>" +
                "                <li><code>docker run --name &lt;name&gt;</code> - Assign a name to container</li>" +
                "                <li><code>docker ps</code> - List running containers</li>" +
                "                <li><code>docker ps -a</code> - List all containers (including stopped)</li>" +
                "                <li><code>docker stop &lt;container-id&gt;</code> - Stop a running container</li>" +
                "                <li><code>docker start &lt;container-id&gt;</code> - Start a stopped container</li>" +
                "                <li><code>docker rm &lt;container-id&gt;</code> - Remove a container</li>" +
                "                <li><code>docker logs &lt;container-id&gt;</code> - View container logs</li>" +
                "                <li><code>docker exec -it &lt;container-id&gt; /bin/bash</code> - Open shell in running container</li>" +
                "            </ul>" +
                "            <h3>System Commands</h3>" +
                "            <ul>" +
                "                <li><code>docker system prune</code> - Remove unused data (containers, networks, images)</li>" +
                "                <li><code>docker system prune -a</code> - Remove all unused images too</li>" +
                "                <li><code>docker volume prune</code> - Remove unused volumes</li>" +
                "            </ul>" +
                "        </div>" +
                "" +
                "        <button class='accordion'>🎼 Docker Compose Overview</button>" +
                "        <div class='panel'>" +
                "            <h3>What is Docker Compose?</h3>" +
                "            <p>Docker Compose is a tool for defining and running multi-container Docker applications. You define services in a YAML file.</p>" +
                "            <h4>Basic Structure:</h4>" +
                "            <pre>services:\n" +
                "  app:\n" +
                "    build: .\n" +
                "    ports:\n" +
                "      - \"8080:8080\"\n" +
                "    depends_on:\n" +
                "      - postgres\n" +
                "\n" +
                "  postgres:\n" +
                "    image: postgres:13\n" +
                "    environment:\n" +
                "      POSTGRES_DB: productdb\n" +
                "      POSTGRES_USER: user\n" +
                "      POSTGRES_PASSWORD: password\n" +
                "    volumes:\n" +
                "      - postgres-data:/var/lib/postgresql/data\n" +
                "\n" +
                "volumes:\n" +
                "  postgres-data:</pre>" +
                "            <h4>Key Concepts:</h4>" +
                "            <ul>" +
                "                <li><code>services:</code> - Define containers that make up your application</li>" +
                "                <li><code>build:</code> - Build from a Dockerfile in specified directory</li>" +
                "                <li><code>image:</code> - Use a pre-built image from Docker Hub</li>" +
                "                <li><code>ports:</code> - Map host ports to container ports</li>" +
                "                <li><code>depends_on:</code> - Start services in dependency order</li>" +
                "                <li><code>environment:</code> - Set environment variables</li>" +
                "                <li><code>volumes:</code> - Mount volumes for data persistence</li>" +
                "            </ul>" +
                "        </div>" +
                "" +
                "        <button class='accordion'>⚡ Docker Compose Commands</button>" +
                "        <div class='panel'>" +
                "            <h3>Essential Commands</h3>" +
                "            <ul>" +
                "                <li><code>docker-compose up</code> - Create and start all services</li>" +
                "                <li><code>docker-compose up -d</code> - Start in detached mode (background)</li>" +
                "                <li><code>docker-compose up --build</code> - Rebuild images and start services</li>" +
                "                <li><code>docker-compose down</code> - Stop and remove containers, networks</li>" +
                "                <li><code>docker-compose down -v</code> - Also remove volumes (DELETE ALL DATA!)</li>" +
                "                <li><code>docker-compose ps</code> - List containers for this compose project</li>" +
                "                <li><code>docker-compose logs</code> - View logs from all services</li>" +
                "                <li><code>docker-compose logs -f</code> - Follow log output in real-time</li>" +
                "                <li><code>docker-compose logs &lt;service&gt;</code> - View logs for specific service</li>" +
                "                <li><code>docker-compose exec &lt;service&gt; &lt;command&gt;</code> - Execute command in running service</li>" +
                "                <li><code>docker-compose restart &lt;service&gt;</code> - Restart a service</li>" +
                "                <li><code>docker-compose stop</code> - Stop services without removing them</li>" +
                "                <li><code>docker-compose start</code> - Start stopped services</li>" +
                "                <li><code>docker-compose config</code> - Validate and view the compose file</li>" +
                "            </ul>" +
                "            <div class='highlight'>" +
                "                <strong>Pro Tip:</strong> Use <code>docker compose</code> (no hyphen) for the newer version!" +
                "            </div>" +
                "        </div>" +
                "" +
                "        <button class='accordion'>🌐 Docker Networks</button>" +
                "        <div class='panel'>" +
                "            <h3>Container Networking Basics</h3>" +
                "            <p>Docker containers can communicate through networks. Docker Compose automatically creates a network for your services.</p>" +
                "            <h4>Key Concepts:</h4>" +
                "            <ul>" +
                "                <li><strong>Service Names as Hostnames:</strong> Containers in the same compose network can reach each other using service names</li>" +
                "                <li>Example: App container connects to <code>postgres:5432</code> (not <code>localhost:5432</code>)</li>" +
                "                <li><code>localhost</code> inside a container refers to THAT container, not the host machine</li>" +
                "            </ul>" +
                "            <h4>Network Commands:</h4>" +
                "            <ul>" +
                "                <li><code>docker network ls</code> - List all networks</li>" +
                "                <li><code>docker network inspect &lt;network&gt;</code> - View network details</li>" +
                "                <li><code>docker network create &lt;name&gt;</code> - Create a custom network</li>" +
                "                <li><code>docker network connect &lt;network&gt; &lt;container&gt;</code> - Connect container to network</li>" +
                "            </ul>" +
                "            <h4>Without Docker Compose:</h4>" +
                "            <pre># Create a network\n" +
                "docker network create app-network\n" +
                "\n" +
                "# Run postgres on the network\n" +
                "docker run -d --name postgres --network app-network \\\n" +
                "  -e POSTGRES_DB=productdb postgres:13\n" +
                "\n" +
                "# Run app on the same network\n" +
                "docker run -d --name app --network app-network \\\n" +
                "  -p 8080:8080 product-lister-app</pre>" +
                "            <div class='highlight'>" +
                "                <strong>Critical Lesson:</strong> When I used <code>localhost:5432</code> in application.properties, " +
                "                the app container couldn't find PostgreSQL. Changing to <code>postgres:5432</code> (service name) fixed it!" +
                "            </div>" +
                "        </div>" +
                "" +
                "        <button class='accordion'>💾 Docker Volumes (Data Persistence)</button>" +
                "        <div class='panel'>" +
                "            <h3>Why Volumes?</h3>" +
                "            <p>Containers are ephemeral - when removed, their data is lost. Volumes persist data outside containers.</p>" +
                "            <h4>Volume Types:</h4>" +
                "            <ul>" +
                "                <li><strong>Named Volumes:</strong> Managed by Docker, stored in Docker's area</li>" +
                "                <li><strong>Bind Mounts:</strong> Mount a host directory into container</li>" +
                "                <li><strong>Anonymous Volumes:</strong> Created automatically, harder to manage</li>" +
                "            </ul>" +
                "            <h4>Volume Commands:</h4>" +
                "            <ul>" +
                "                <li><code>docker volume ls</code> - List all volumes</li>" +
                "                <li><code>docker volume create &lt;name&gt;</code> - Create a volume</li>" +
                "                <li><code>docker volume inspect &lt;name&gt;</code> - View volume details</li>" +
                "                <li><code>docker volume rm &lt;name&gt;</code> - Remove a volume</li>" +
                "                <li><code>docker volume prune</code> - Remove all unused volumes</li>" +
                "            </ul>" +
                "            <h4>With Docker Compose (Named Volume):</h4>" +
                "            <pre>services:\n" +
                "  postgres:\n" +
                "    image: postgres:13\n" +
                "    volumes:\n" +
                "      - postgres-data:/var/lib/postgresql/data\n" +
                "\n" +
                "volumes:\n" +
                "  postgres-data:</pre>" +
                "            <h4>Without Docker Compose:</h4>" +
                "            <pre># Create volume\n" +
                "docker volume create postgres-data\n" +
                "\n" +
                "# Run with volume\n" +
                "docker run -d --name postgres \\\n" +
                "  -v postgres-data:/var/lib/postgresql/data \\\n" +
                "  postgres:13</pre>" +
                "            <div class='highlight'>" +
                "                <strong>Important:</strong> Data persists only if <code>spring.jpa.hibernate.ddl-auto=update</code> " +
                "                (not <code>create</code> which drops tables on startup!)" +
                "            </div>" +
                "        </div>" +
                "" +
                "        <button class='accordion'>🔧 Common Issues & Solutions</button>" +
                "        <div class='panel'>" +
                "            <h3>Issues I Encountered:</h3>" +
                "            <ul>" +
                "                <li>" +
                "                    <strong>Connection refused to localhost:5432</strong><br>" +
                "                    <em>Solution:</em> Changed <code>localhost</code> to service name <code>postgres</code> in application.properties" +
                "                </li>" +
                "                <li>" +
                "                    <strong>Duplicate key violations on restart</strong><br>" +
                "                    <em>Solution:</em> Changed <code>ddl-auto=create</code> to <code>update</code> and <code>sql.init.mode=always</code> to <code>never</code>" +
                "                </li>" +
                "                <li>" +
                "                    <strong>Tests failing - Testcontainers needs Docker</strong><br>" +
                "                    <em>Solution:</em> Added H2 in-memory database for tests with separate <code>application.properties</code> in test resources" +
                "                </li>" +
                "                <li>" +
                "                    <strong>JPA needs no-arg constructor</strong><br>" +
                "                    <em>Solution:</em> Added empty constructor to Product entity class" +
                "                </li>" +
                "                <li>" +
                "                    <strong>Schema mismatch between data.sql and entity</strong><br>" +
                "                    <em>Solution:</em> Simplified data.sql to match entity fields (id, name, price only)" +
                "                </li>" +
                "            </ul>" +
                "        </div>" +
                "" +
                "        <button class='accordion'>📋 Complete Workflow Example</button>" +
                "        <div class='panel'>" +
                "            <h3>Building and Running the Product Lister Application</h3>" +
                "            <h4>Step 1: Build the JAR</h4>" +
                "            <pre>mvn clean package</pre>" +
                "            <h4>Step 2: Build and Start Containers</h4>" +
                "            <pre>docker-compose up --build</pre>" +
                "            <h4>Step 3: Access the Application</h4>" +
                "            <ul>" +
                "                <li>Homepage: <code>http://localhost:8080/</code></li>" +
                "                <li>Products API: <code>http://localhost:8080/products</code></li>" +
                "                <li>Add Product: <code>http://localhost:8080/addProduct</code></li>" +
                "            </ul>" +
                "            <h4>Step 4: View Logs</h4>" +
                "            <pre>docker-compose logs -f app</pre>" +
                "            <h4>Step 5: Stop Everything</h4>" +
                "            <pre>docker-compose down</pre>" +
                "            <h4>Step 6: Clean Up (INCLUDING DATA!)</h4>" +
                "            <pre>docker-compose down -v</pre>" +
                "            <h3>Architecture:</h3>" +
                "            <pre>┌─────────────────────────────────────────┐\n" +
                "│         Docker Compose Network          │\n" +
                "│                                         │\n" +
                "│  ┌─────────────┐      ┌──────────────┐ │\n" +
                "│  │  App (8080) │─────▶│  PostgreSQL  │ │\n" +
                "│  │  Container  │      │  Container   │ │\n" +
                "│  └─────────────┘      └──────────────┘ │\n" +
                "│         │                     │         │\n" +
                "│         │                     │         │\n" +
                "│    [Docker Image]      [Named Volume]  │\n" +
                "│   (Built from         (postgres-data)  │\n" +
                "│    Dockerfile)                          │\n" +
                "└─────────────────────────────────────────┘\n" +
                "         │\n" +
                "         ▼\n" +
                "   Host Machine\n" +
                "   localhost:8080</pre>" +
                "        </div>" +
                "" +
                "        <button class='accordion'>🎓 Key Takeaways</button>" +
                "        <div class='panel'>" +
                "            <h3>What I Learned:</h3>" +
                "            <ul>" +
                "                <li> How to write a Dockerfile for a Spring Boot application</li>" +
                "                <li> Docker Compose simplifies multi-container applications dramatically</li>" +
                "                <li> Container networking: service names become hostnames</li>" +
                "                <li> Named volumes persist data across container restarts</li>" +
                "                <li> <code>depends_on</code> ensures proper startup order</li>" +
                "                <li> Application configuration differs between Docker and local development</li>" +
                "                <li> Test environments should be isolated (H2 for tests, PostgreSQL for production)</li>" +
                "                <li> <code>ddl-auto=create</code> drops data on restart - use <code>update</code> for persistence</li>" +
                "                <li> Always build the JAR before building the Docker image</li>" +
                "                <li> Docker makes it easy to share and deploy applications consistently</li>" +
                "            </ul>" +
                "            <div class='highlight'>" +
                "                <strong>Most Important Lesson:</strong> Understanding the difference between container networking " +
                "                (service names) and host networking (localhost) was crucial for getting the database connection working!" +
                "            </div>" +
                "        </div>" +
                "" +
                "    </div>" +
                "" +
                "    <script>" +
                "        var acc = document.getElementsByClassName('accordion');" +
                "        for (var i = 0; i < acc.length; i++) {" +
                "            acc[i].addEventListener('click', function() {" +
                "                this.classList.toggle('active');" +
                "                var panel = this.nextElementSibling;" +
                "                if (panel.style.maxHeight) {" +
                "                    panel.style.maxHeight = null;" +
                "                } else {" +
                "                    panel.style.maxHeight = panel.scrollHeight + 'px';" +
                "                }" +
                "            });" +
                "        }" +
                "    </script>" +
                "</body>" +
                "</html>";
    }
}
