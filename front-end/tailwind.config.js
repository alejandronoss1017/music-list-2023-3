/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,ts}"],
  theme: {
    extend: {
      colors: {
        "tea-green": "#BDD9BF",
        "russian-violet": "#0C0A3E",
        goldenrod: "#D79B1F",
        white: "#FFFFFF",
        "dark-purple": "#412234",
      },
      fontSize: {
        sm: "0.8rem",
        base: "1rem",
        lg: "1.15rem",
        xl: "1.25rem",
        "2xl": "1.563rem",
        "3xl": "1.953rem",
        "4xl": "2.441rem",
        "5xl": "3.052rem",
        "6xl": "3.5rem",
      },
      fontFamily: {
        poppins: ["Poppins", "sans-serif"],
      },
    },
  },
  plugins: [],
};
