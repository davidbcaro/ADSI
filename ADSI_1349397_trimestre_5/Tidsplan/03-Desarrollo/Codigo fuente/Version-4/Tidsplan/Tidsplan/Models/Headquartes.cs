using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace Tidsplan.Models
{
    public class Headquartes
    {
        [Key]
        public int headquartesID { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display (Name = "Nombre de la sede")]
        [StringLength(30, ErrorMessage = "Debe tener mínimo dos caracteres, máximo treinta caracteres.", MinimumLength = 2)]
        [Index("Headquartes_nameHeadquartes_Index", IsUnique = true)]
        public String nameHeadquartes { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Nombre de la sede")]
        public String toUpper
        {
            get
            {
                if (nameHeadquartes != null)
                {
                    nameHeadquartes = nameHeadquartes.ToUpper();
                }
                else
                {
                    nameHeadquartes = "Es requerido.";
                }
                return nameHeadquartes;
            }
            set
            {
                if (nameHeadquartes != null)
                {
                    nameHeadquartes = nameHeadquartes.ToUpper();
                }
                else
                {
                    nameHeadquartes = "Es requerido.";
                }
                nameHeadquartes.ToUpper();
            }
        }

        [Required (ErrorMessage = "Es requerido.")]
        [Display(Name = "Dirección")]
        [StringLength(30, ErrorMessage = "Debe tener mínimo dos caracteres, máximo treinta caracteres.", MinimumLength = 2)]
        [Index("Headquartes_address_Index", IsUnique = true)]
        public String address { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Dirección")]
        public String toUpper2
        {
            get
            {
                if (address != null)
                {
                    address = address.ToUpper();
                }
                else
                {
                    address = "Es requerido.";
                }
                return address;
            }
            set
            {
                if (address != null)
                {
                    address = address.ToUpper();
                }
                else
                {
                    address = "Es requerido.";
                }
                address.ToUpper();
            }
        }

        public virtual ICollection<Schedule> schedule { get; set; }

    }
}
