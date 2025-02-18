.PHONY: primeiro-build build reload start stop logs reset-db restart-backend restart-frontend restart-tudo

# 🚀 Primeiro build do projeto (somente uma vez)
primeiro-build:
	docker compose down -v
	docker compose build --no-cache
	docker compose up -d

# 🔄 Build completo, removendo cache e reconstruindo tudo
build:
	docker compose down
	docker compose rm -f backend frontend
	docker volume prune -f
	docker compose build --no-cache
	docker compose up -d

# 🔄 Recarregar backend e frontend, mantendo o banco de dados
reload:
	docker compose down
	docker compose rm -f backend frontend
	docker compose up -d --build

# 🏁 Iniciar os serviços sem reconstrução (uso diário)
start:
	docker compose up --build -d

# ⏹️ Parar os serviços
stop:
	docker compose down

# 📜 Ver logs em tempo real
logs:
	docker compose logs -f

# 🔄 Resetar apenas o banco de dados, sem mexer no backend/frontend
reset-db:
	docker compose down -v
	docker compose up -d

# 🔄 Reiniciar apenas o backend
restart-backend:
	docker compose restart backend

# 🔄 Reiniciar apenas o frontend
restart-frontend:
	docker compose restart frontend

# 🔄 Reiniciar backend e frontend juntos
restart:
	docker compose restart backend frontend
