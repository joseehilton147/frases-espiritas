# Usa a imagem oficial do Node.js para produção
FROM node:20-alpine AS builder

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia os arquivos de dependências do projeto
COPY package.json package-lock.json ./

# Instala as dependências sem gerar arquivos desnecessários
RUN npm install --frozen-lockfile

# Copia o restante do código para dentro do container
COPY . .

# Compila o projeto Next.js
RUN npm run build

# Usa uma imagem menor para rodar a aplicação final
FROM node:20-alpine AS runner
WORKDIR /app

# Copia os arquivos do build para a imagem final
COPY --from=builder /app ./

# Expõe a porta do Next.js
EXPOSE 3000

# Comando para rodar o Next.js no modo produção
CMD ["npm", "start"]