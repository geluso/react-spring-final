import { createBrowserRouter } from "react-router-dom";

import Root from "./Root";
import Home from "./Home";
import About from "./About";
import Users from "./Users";
import BootstrapColumns from "./BootstrapColumns";
import TopSongs from "./TopSongs";

import Timestamp from "../components/time/Timestamp";

const routes = [
    {
        name: "Home",
        path: "/",
        element: <Home />
    },
    {
        name: "About",
        path: "/about",
        element: <About />
    },
    {
        name: "Auto Cols",
        path: "/cols-auto",
        element: <BootstrapColumns />
    },
    {
        name: "Users",
        path: "/users",
        element: <Users />
    },
    {
        name: "Top Songs",
        path: "/top-songs",
        element: <TopSongs />
    },
    {
        name: "Break",
        path: "/Break",
        element: <div>
            <h1>Break</h1>
            <p>Come back at <Timestamp hour={1} minute={35} /></p>
        </div>
    },
]

const router = createBrowserRouter([
    {
        path: "/",
        element: <Root />,
        children: routes,
    },
]);

export {
    routes,
    router,
}