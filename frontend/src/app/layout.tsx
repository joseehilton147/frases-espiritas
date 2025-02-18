import type { Metadata } from "next";
import { Geist, Geist_Mono, Nunito } from "next/font/google";
import "./globals.css";

const geistSans = Geist({
	variable: "--font-geist-sans",
	subsets: ["latin"],
});

const geistMono = Geist_Mono({
	variable: "--font-geist-mono",
	subsets: ["latin"],
});

const nunito = Nunito({
	subsets: ["latin"],
	weight: ["400", "700"],
	variable: "--font-nunito", // Aplicamos como variável
});

export const metadata: Metadata = {
	title: "Frases Espíritas",
	description: "Frases inspiradoras para o seu dia.",
};

export default function RootLayout({
									   children,
								   }: Readonly<{
	children: React.ReactNode;
}>) {
	return (
		<html lang="pt-br">
		<body
			className={`${geistSans.variable} ${geistMono.variable} ${nunito.variable} bg-blue-400 text-white antialiased`}
		>
		{children}
		</body>
		</html>
	);
}
