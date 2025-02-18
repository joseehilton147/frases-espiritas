import api from "../app/utils/api"
import { Frase } from "@/types/frase"

export async function getFraseAleatoria(): Promise<Frase> {
	const { data } = await api.get<Frase>("/frases/aleatoria")

	return data
}

export async function criarFrase(autor: string, conteudo: string) {
	const { data } = await api.post("/frases", { autor, conteudo })

	return data
}
