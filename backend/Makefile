OS := $(shell uname 2>/dev/null || echo Windows)

MIGRATION_NAME := $(name)
MIGRATION_SCRIPT_WIN := $(CURDIR)/scripts/create_migration.ps1
MIGRATION_SCRIPT_LINUX := backend/scripts/create_migration.sh

.PHONY: migration

migration:
ifeq ($(OS), Windows)
	@powershell -ExecutionPolicy Bypass -File "$(MIGRATION_SCRIPT_WIN)" "$(MIGRATION_NAME)"
else
	@bash "$(MIGRATION_SCRIPT_LINUX)" "$(MIGRATION_NAME)"
endif