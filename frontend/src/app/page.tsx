"use client";

import { useEffect, useState } from "react";
import { getFraseAleatoria } from "@/api/frases";
import { Frase } from "@/types/frase";

export default function Home() {
	const [frase, setFrase] = useState<Frase | null>(null);
	const [loading, setLoading] = useState(false);

	async function fetchFrase() {
		if (loading) return;
		setLoading(true);
		try {
			const data = await getFraseAleatoria();
			setFrase(data);
		} catch {
			setFrase({ conteudo: "Erro ao carregar frase.", autor: "" });
		} finally {
			setLoading(false);
		}
	}

	useEffect(() => {
		fetchFrase();

		const handleKeyDown = (event: KeyboardEvent) => {
			if (event.key === " " || event.key === "Enter") {
				fetchFrase();
			}
		};
		window.addEventListener("keydown", handleKeyDown);

		return () => window.removeEventListener("keydown", handleKeyDown);
	}, []);

	return (
		<main
			className="flex flex-col items-center justify-center min-h-screen text-center cursor-pointer px-6"
			onClick={fetchFrase}
		>
			<div className="p-6">
				<h1 className="text-2xl md:text-4xl font-semibold leading-tight">{frase?.conteudo || "Carregando..."}</h1>
				{frase?.autor && <p className="mt-3 text-lg text-white/80">— {frase.autor}</p>}
			</div>
			<p className="mt-6 text-white/70 text-sm">
				Pressione <kbd className="border px-2 py-1 rounded-md">Espaço</kbd> ou <kbd className="border px-2 py-1 rounded-md">Enter</kbd> ou <span className="underline">clique</span>
			</p>
			<footer className="absolute bottom-4 text-white/70 text-xs">
				Fonte: <a href="https://github.com/seu-repositorio" target="_blank" className="underline">GitHub</a>
			</footer>
		</main>
	);
}
