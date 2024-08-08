import React from 'react';
import AliceCarousel from 'react-alice-carousel';
import 'react-alice-carousel/lib/alice-carousel.css';
import { mainCaroselData } from './MainCaroselData';



const MainCarosel = () => {
    const items = mainCaroselData.map((item, index) =>
        <img src={item.image} alt={index} role='presentation' className="cursor-pointer -z-10" onClick={null} />)

    return (
        <AliceCarousel
            mouseTracking
            items={items}
            disableButtonsControls
            autoPlay
            autoPlayInterval={2000}
            infinite
        />
    );
};

export default MainCarosel;