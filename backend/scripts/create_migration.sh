#!/bin/bash

MIGRATION_DIR="backend/src/main/resources/db/migration"

# Criar o diretório se não existir
mkdir -p "$MIGRATION_DIR"

# Encontrar a última versão existente
VERSION=$(ls "$MIGRATION_DIR" | grep -E '^V[0-9]+__' | sed -E 's/^V([0-9]+)__.*$/\1/' | sort -n | tail -1)

# Se não houver migrações, começa com V1
if [ -z "$VERSION" ]; then
  VERSION=1
else
  VERSION=$((VERSION + 1))
fi

# Criar o novo arquivo de migração
FILENAME="$MIGRATION_DIR/V${VERSION}__$1.sql"
touch "$FILENAME"
echo "✅ Nova migração criada: $FILENAME"